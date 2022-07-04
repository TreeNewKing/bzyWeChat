package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.User;
import com.TreeNewKing.bzyWechat.model.req.LoginRequest;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * 用户表;(user)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-7-3
 */
public interface UserService{

  User login(LoginRequest loginRequest);
  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  User queryById(String id);

  /**
   * 分页查询
   *
   * @param user 筛选条件
   * @param current 当前页码
   * @param size  每页大小
   * @return
   */
  Page<User> paginQuery(User user, long current, long size);
  /**
   * 新增数据
   *
   * @param user 实例对象
   * @return 实例对象
   */
  User insert(User user);
  /**
   * 更新数据
   *
   * @param user 实例对象
   * @return 实例对象
   */
  User update(User user);
  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  boolean deleteById(String id);
}