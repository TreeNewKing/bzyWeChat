// app.ts
App<IAppOption>({
  globalData: {
  },
  onLaunch() {
    // 使用云托管
    if (!wx.cloud) {
      console.error('请使用 2.2.3 以上版本的基础库');
    } else {
      wx.cloud.init({
        env: 'prod-9gpx0wysac930832'
      })
    }


    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        console.log(res.code)
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      },
    })
  }
})