// pages/detail/detail.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bodyType: '',
    body: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options: any) {
    this.setData({
      bodyType: JSON.parse(options.bodyType_id),
      body: JSON.parse(options.body) + '体质茶叶推荐'
    })
    console.log('detail', this.data.body)
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