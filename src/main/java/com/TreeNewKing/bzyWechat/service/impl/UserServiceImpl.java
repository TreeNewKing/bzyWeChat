package com.TreeNewKing.bzyWechat.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.TreeNewKing.bzyWechat.common.Constant;
import com.TreeNewKing.bzyWechat.dao.UserMapper;
import com.TreeNewKing.bzyWechat.error.AppException;
import com.TreeNewKing.bzyWechat.model.entity.User;
import com.TreeNewKing.bzyWechat.model.req.LoginRequest;
import com.TreeNewKing.bzyWechat.model.resp.AuthResp;
import com.TreeNewKing.bzyWechat.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


    final UserMapper userMapper;

    final RestTemplate restTemplate;



    public UserServiceImpl(@Autowired UserMapper userMapper,@Autowired RestTemplate restTemplate) {
        this.userMapper = userMapper;
        this.restTemplate=restTemplate;
    }

    @Override
    @Transactional
    public User login(LoginRequest loginRequest) {
        AuthResp authResp = getOpenId1(loginRequest.getCode());
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("open_id", authResp.getOpenid());
        User user = userMapper.selectOne(wrapper);
        Date now = new Date();
        if (user==null){
            user = new User();
            user.setOpenId(authResp.getOpenid());
            user.setNickname(loginRequest.getNickname());
            user.setAvatar(loginRequest.getAvatar());
            user.setCreateTime(now);
            user.setModifyTime(now);
            user.setIsAdmin(0);
            log.info("UserService.login() insert user : open_id = "+user.getOpenId()+" nickname = "+user.getNickname());
            userMapper.insert(user);
        }else{
            user.setModifyTime(now);
            user.setAvatar(loginRequest.getAvatar());
            user.setNickname(loginRequest.getNickname());
            log.info("UserService.login() update user : open_id = "+user.getOpenId()+" nickname = "+user.getNickname());
            userMapper.updateById(user);
        }
        return user;
    }

    public User queryById(String id){
        return userMapper.selectById(id);
    }
    AuthResp getOpenId1(String code){
        AuthResp authResp = new AuthResp();
        authResp.setOpenid("temp");
        return authResp;
    }
    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<User> paginQuery(User user, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(user.getOpenId())){
            queryWrapper.eq(User::getOpenId, user.getOpenId());
        }
        if(StrUtil.isNotBlank(user.getAvatar())){
            queryWrapper.eq(User::getAvatar, user.getAvatar());
        }
        //2. 执行分页查询
        Page<User> pagin = new Page<>(current , size , true);
        IPage<User> selectResult = userMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public User insert(User user){
        userMapper.insert(user);
        return user;
    }

    /**
     * 更新数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public User update(User user){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<User> chainWrapper = new LambdaUpdateChainWrapper<User>(userMapper);
        if(StrUtil.isNotBlank(user.getOpenId())){
            chainWrapper.eq(User::getOpenId, user.getOpenId());
        }
        if(StrUtil.isNotBlank(user.getAvatar())){
            chainWrapper.eq(User::getAvatar, user.getAvatar());
        }
        //2. 设置主键，并更新
        chainWrapper.set(User::getId, user.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(user.getId());
        }else{
            return user;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(String id){
        int total = userMapper.deleteById(id);
        return total > 0;
    }


    private AuthResp getOpenId(String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appId}&secret={secret}&js_code={jsCode}&grant_type=authorization_code}";
        Map<String,String> map = new HashMap<>();
        map.put("appId", Constant.APP_ID);
        map.put("secret",Constant.SECRET);
        map.put("jsCode",code);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, map);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        try {
            AuthResp authResp = objectMapper.readValue(response.getBody(), AuthResp.class);
            if(authResp.getErrmsg()!=null){
                throw new AppException("授权失败,等待修复.");
            }else{
                return authResp;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new AppException("授权失败,等待修复.");
        }
    }
}
