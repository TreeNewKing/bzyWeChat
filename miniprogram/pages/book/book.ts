// pages/book/book.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sourceData: {
      professional: '',
      teaAge: -1,
      height: -1,
      weight: -1,
      growthIn: '',
      lifeIn: '',
      favoriteTea: '',
    },
    questions: [],
    bodyTypes: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  async onLoad(options: {id: string}) {
    try {
      const id: String = options.id
      const res = await wx.cloud.callContainer({
        path: '/api/history/detail?id=' + id,
        method: 'POST',
        header: {
          "X-WX-SERVICE": "springboot-cxiq",
          "Authorization": wx.getStorageSync('token')
        }
      })
      if (res.statusCode === 200) {
        const resData: {info: any, problem: any, bodyTypes: any} = res.data
        this.setData({
          sourceData: resData.info,
          questions: resData.problem,
          bodyTypes: resData.bodyTypes
        })
        console.log(this.data)
      }
    } catch (error) {
      console.log(error)
    }
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

  }
})