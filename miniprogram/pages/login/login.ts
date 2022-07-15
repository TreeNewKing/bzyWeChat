// pages/login/login.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  },

  clickToLogin () {
    wx.getUserProfile({
      desc: '注册，登录小程序',
      success: res => {
        if (res.userInfo) {
          /* wx.login 调用接口获取登录凭证（code）。通过凭证进而换取用户登录态信息，包括用户在当前小程序的唯一标识（openid）、微信开放平台帐号下的唯一标识（unionid，若当前小程序已绑定到微信开放平台帐号）及本次登录的会话密钥（session_key）*/
          wx.login({
            success: ret => {
              // 获取code
              var code = ret.code;
              // 获取用户昵称
              var nickName = res.userInfo.nickName;
              // 获取用户照片
              var avatarUrl = res.userInfo.avatarUrl;
              // 发送至后端
              wx.cloud.callContainer({
                path: '/api/user/login',
                data: {
                  code: code,
                  nickName: nickName,
                  avatarUrl: avatarUrl
                },
                method:"POST",
                header: {
                  'X-WX-SERVICE': 'springboot-cxiq',
                  'content-type': 'application/json' // 默认值
                },
                // 数据返回
                success (resp) {
                  console.log('login resp', resp.data);
                  // 将用户id储存于本地
                  wx.setStorageSync('token', resp.data.data.token);
                  // 将用户微信信息设置成小程序信息
                  wx.setStorageSync('userName', res.userInfo.nickName)
                  wx.setStorageSync('userAvatar', res.userInfo.avatarUrl)
                  // 重启动个人中心
                  wx.reLaunch({
                    url: '/pages/list/list'
                  })
                }
              })
            }
          })
        } else {
        }
      },
      fail: err => {
        console.log('登录失败', err)
      }
    })
  }
})