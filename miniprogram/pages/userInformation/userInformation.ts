// pages/userInformation/userInformation.ts
import Dialog from '../../miniprogram_npm/@vant/weapp/dialog/dialog';

Page({

  /**
   * 页面的初始数据
   */
  data: {
    nickName: '',
    showNickName: false,
    changedNickName: '',
    height: '',
    showHeight: false,
    changedHeight: '',
    weight: '',
    showWeight: false,
    changedWeight: '',
    teaAge: '',
    showTeaage: false,
    changedTeaage: '',
    favoriteTea: '',
    showFavorite: false,
    changedFavorite: '',
    professional: '',
    showProfession: false,
    changedProfession: '',
    growthIn: '',
    showGrowthin: false,
    changedGrowthin: '',
    lifeIn: '',
    showLifein: false,
    changedLifein: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    wx.cloud.callContainer({
      path: '/api/survey/info',
      method: 'GET',
      header: {
        "X-WX-SERVICE": "springboot-cxiq",
        "content-type": "application/json",
        "Authorization": wx.getStorageSync('token')
      },
      success: res => {
        const resData: {height: number, weight: number, teaAge: number, favoriteTea: string, professional: string, growthIn: string, lifeIn: string} = res.data.data
        this.setData({
          nickName: wx.getStorageSync('userName'),
          height: (resData.height).toString(),
          weight: (resData.weight).toString(),
          teaAge: (resData.teaAge).toString(),
          favoriteTea: resData.favoriteTea,
          growthIn: resData.growthIn,
          lifeIn: resData.lifeIn,
          professional: resData.professional
        })
      },
      fail: err => {
        console.log('get userInformation error', err)
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

  // nickname
  clickToNickname () {
    this.setData({
      showNickName: true
    })
  },
  cancelChangeNickname() {
    this.setData({
      changedNickName: this.data.nickName
    })
  },
  confirmChangeNickname () {
    this.setData({
      nickName: this.data.changedNickName
    })
  },
  // height
  clickToHeight () {
    this.setData({
      showHeight: true
    })
  },
  cancelChangeHeight () {
    this.setData({
      changedHeight: this.data.height
    })
  },
  confirmChangeHeight () {
    this.setData({
      height: this.data.changedHeight
    })
  },
  //weight
  clickToWeight () {
    this.setData({
      showWeight: true
    })
  },
  cancelChangeWeight () {
    this.setData({
      changedWeight: this.data.weight
    })
  },
  confirmChangeWeight () {
    this.setData({
      weight: this.data.changedWeight
    })
  },
  // teaage
  clickToTeaage () {
    this.setData({
      showTeaage: true 
    })
  },
  cancelChangeTeaage () {
    this.setData({
      changedTeaage: this.data.teaAge
    })
  },
  confirmChangeTeaage () {
    this.setData({
      teaAge: this.data.changedTeaage
    })
  },
  // favorite
  clickToFavorite () {
    this.setData({
      showFavorite: true
    })
  },
  cancelChangeFavorite () {
    this.setData({
      changedFavorite: this.data.favoriteTea
    })
  },
  confirmChangeFavorite () {
    this.setData({
      favoriteTea: this.data.changedFavorite
    })
  },
  // profession
  clickToProfession () {
    this.setData({
      showProfession: true
    })
  },
  cancelChangeProfession () {
    this.setData({
      changedProfession: this.data.professional
    })
  },
  confirmChangeProfession () {
    this.setData({
      professional: this.data.changedProfession
    })
  },
  // growthin
  clickToGrowthin () {
    this.setData({
      showGrowthin: true
    })
  },
  cancelChangeGrowthin () {
    this.setData({
      changedGrowthin: this.data.growthIn
    })
  },
  confirmChangeGrowthin () {
    this.setData({
      growthIn: this.data.changedGrowthin
    })
  },
  // lifein
  clickToLifein () {
    this.setData({
      showLifein: true
    })
  },
  cancelChangeLifein () {
    this.setData({
      changedLifein: this.data.lifeIn
    })
  },
  confirmChangeLifein () {
    this.setData({
      lifeIn: this.data.changedLifein
    })
  }
})