// pages/recommend/recommend.ts
Page({
  /**
   * 页面的初始数据
   */
  data: {
    recommendBody: [{
      name: '痰湿质(E型)',
      id: '1'
    }, {
      name: '阳虚质(C型)',
      id: '2'
    }],
    relativeBody: [{
      name :'湿热质(F型)',
      id: '3'
    }, {
      name :'湿热质(F型)',
      id: '3'
    }, {
      name :'湿热质(F型)',
      id: '3'
    }, {
      name :'湿热质(F型)',
      id: '3'
    }]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options: {bodyArr: string}) {
    console.log('rec options', JSON.parse(options.bodyArr))
    const arr: Array<{id: String, name: String, result: Number}> = JSON.parse(options.bodyArr)
    const arr_com: any = []
    const arr_rel: any = []
    arr.forEach((e: {id: String, name: String, result: Number})=> {
      if (e.result === 2) {
        e.name = e.name.replace(/[ ]/g, '')
        arr_com.push(e)
      } else if (e.result === 1) {
        e.name = e.name.replace(/[ ]/g, '')
        arr_rel.push(e)
      }
    })
    this.setData({
      recommendBody: arr_com,
      relativeBody: arr_rel
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

  clickToBody () {
    wx.navigateTo({
      url: '/pages/check/check'
    })
  },

  clickToTea (e: any) {
    const event: {name: String, bodytype: String} = {
      name: e.target.dataset.item.name,
      bodytype: e.target.dataset.item.id
    }
    wx.navigateTo({
      url: '/pages/detail/detail?bodyType_id=' + JSON.stringify(event.bodytype) + '&body=' + JSON.stringify(event.name) 
    })
  }
})