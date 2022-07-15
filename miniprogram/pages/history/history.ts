// pages/history/history.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNull: false,
    record: [{
      id: 'record1',
      createTime: '2022-07-10'
    },{
      id: 'record2',
      createTime: '2022-07-10'
    },{
      id: 'record3',
      createTime: '2022-07-10'
    }]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    wx.cloud.callContainer({
      path: '/api/history/simple',
      method: 'POST',
      header: {
        "X-WX-SERVICE": "springboot-cxiq",
        "Authorization": wx.getStorageSync('token')
      },
      success: res => {
        const resData = res.data
        this.setData({
          record: resData
        })
      },
      fail: err => {
        console.log(err)
      }
    })
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

  async clickToDetail (e: any) {
    wx.navigateTo({
      url: '/pages/book/book?id=' + e.target.dataset.item
    })
  }
})