// pages/book/book.ts
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';
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
    options: [
      {
        id: '1',
        description: '没有(根本不/从来没有)',
      }, {
        id: '2',
        description: '很少(有一点/偶尔)',
      }, {
        id: '3',
        description: '有时(有些/少数时间)',
      },{
          id: '4',
          description: '经常(相当多数时间)',
      },{
          id: '5',
          description: '总是(非常每天)',
      }
    ],
    recArr: [],
    relArr: [],
    rec: '',
    rel: '',
    loading: true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  async onLoad(options: {id: string}) {
    Toast.loading({
      message: '加载中...',
      forbidClick: true,
    });
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
        resData.bodyTypes.forEach((e: any) => {
          if (e.result === '1') {
            e.name = e.name.replace(/[ ]/g, '')
            if (this.data.rel === '') {
              this.setData({
                rel: e.name
              })
            } else {
              this.setData({
                rel: this.data.rel + '、' + e.name
              })
            }
          } else if (e.result === '2') {
            e.name = e.name.replace(/[ ]/g, '')
            if (this.data.rec === '') {
              this.setData({
                rec: e.name
              })
            } else {
              this.setData({
                rec: this.data.rec + '、' + e.name
              })
            }
          }
        })
        this.setData({
          sourceData: resData.info,
          questions: resData.problem
        })
        console.log(this.data)
      }
    } catch (error) {
      console.log(error)
    } finally {
      this.setData({
        loading: false
      })
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