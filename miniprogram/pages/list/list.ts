// pages/list/list.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userAvatar: 'http://82.157.232.71/images/wx/user-black.png',
    userName: '用户名'
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

  toSetting () {
    wx.openSetting()
  },

  clickToLogin () {
    wx.login({
      success: res => {
        console.log('clickToLogin', res)
      }
    })
    this.getUserInfo()
  },

  async getLocation () {
    const res = await wx.getLocation({})
    console.log(res);
  },

  async getUserInfo () {
    const _this = this
    //    wx.getUserProfile获取用户信息
    wx.getUserProfile({
      // desc 声明获取用户个人信息后的用途，不超过30个字符
      desc: 'desc',
      success: res => {
        if (res.userInfo) {
          console.log(res);
          // 待删除
          _this.setData({
            userAvatar: res.userInfo.avatarUrl,
            userName: res.userInfo.nickName
          })
          /*  wx.login 调用接口获取登录凭证（code）。通过凭证进而换取用户登录态信息，包括用户在当前小程序的唯一标识（openid）、微信开放平台帐号下的唯一标识（unionid，若当前小程序已绑定到微信开放平台帐号）及本次登录的会话密钥（session_key）*/
          wx.login({
            success: ret => {
              // 获取code
              var code = ret.code;
              // 获取用户昵称
              var nickName = res.userInfo.nickName;
              // 获取用户照片
              var avatarUrl = res.userInfo.avatarUrl;
              // 发送至后端
              wx.request({
                url: '',
                data: {
                  code: code,
                  nickName: nickName,
                  avatarUrl: avatarUrl
                },
                method:"POST",
                header: {
                  'content-type': 'application/json' // 默认值
                },
                // 数据返回
                success (resp) {
                  console.log(resp.data);
                  // 将用户id储存于本地
                  // wx.setStorageSync('userid', resp.data.id);
                  // 将用户微信信息设置成小程序信息
                  _this.setData({
                    userAvatar: res.userInfo.avatarUrl,
                    userName: res.userInfo.nickName
                  })
                  wx.switchTab({
                    // 跳转至首页
                    url: '/pages/index/index',
                  })
                }
              })
            }
          })
        } else {
          console.log('用户拒绝啦');
        }
      }
    })
  },

  check_authSetting_userLocation(){
    const _this = this;
    wx.getSetting({
      success (res) {
        console.log(res.authSetting)
        if(!res.authSetting['scope.userLocation']){
          wx.authorize({
            scope: 'scope.userLocation',
            success (res) {
              console.log('获取地理位置授权成功')
              _this.getLocation()
            },
            fail(err){
              console.log('获取地理位置授权失败')
              console.log(err)
              wx.showModal({
                title: '小程序需要获取您的位置信息',
                content: '请允许获取您的位置信息，否则小程序部分功能将无法使用',
                success (res) {
                  if (res.confirm) {
                    wx.openSetting({
                      success (res) {
                        console.log('成功',res)
                        if(res.authSetting['scope.userLocation']){
                          _this.getLocation();
                        }
                      },
                      fail(err){
                        console.log(err)
                      }
                    })
                  } else if (res.cancel) {
                    console.log('用户点击取消')
                  }
                }
              })
            }
          })
        }else{
          console.log('获取地理位置已授权')
          _this.getLocation();
        }
      },
      fail:function(err){
        console.log(err)
      }
    })
  },

  async clickToLogout () {
    console.log('clickToLogout')
  }
})