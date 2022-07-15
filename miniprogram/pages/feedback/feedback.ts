// pages/feedback/feedback.ts
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fileList: [],
    describe: '',
    title: '',
    email: ''
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

  async submitFeedback () {
    console.log(this.data)
    if (this.data.describe === '' || this.data.title === '') {
      Toast.fail('请输入要反馈的内容！');
      return
    }
    wx.cloud.callContainer({
      path: '/api/feedback',
      method: 'POST',
      header: {
        "Authorization": wx.getStorageSync('token'),
        "X-WX-SERVICE": "springboot-cxiq",
        "content-type": "application/json",
      },
      data: {
        title: this.data.title,
        describe: this.data.describe,
        email: this.data.email
      },
      success: res => {
        if (res.statusCode === 200) {
          Toast.success('反馈成功！')
        }
      },
      fail: err => {
        console.log('submit feedback error', err)
      }
    })
  }
})