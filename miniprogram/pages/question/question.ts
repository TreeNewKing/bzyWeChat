// pages/question/question.ts
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    questions: [{
      id: '1',
      description: '您精力充沛吗？(指精神头足，乐于做事)',
      type: 0,
      options: [{
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
      }]
    }, {
      id: '2',
      description: '您容易疲乏吗？(指体力如何，是否稍微活动一下或做一点家务劳动就感到累)*',
      type: 0,
      options: [{
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
      }]
    }, {
      id: '3',
      description: '您容易气短，呼吸短促，接不上气吗？',
      type: 0,
      options: [{
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
      }]
    }],
    infoData: {
      weight: -1,
      height: -1,
      favoriteTea: '',
      teaAge: '', 
      lifeIn: '', 
      growthIn: '', 
      professional: ''
    },
    answers: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    // 获取全部题目
    wx.cloud.callContainer({
      path: '/api/survey/',
      method: 'GET',
      header: {
        'X-WX-SERVICE': 'springboot-cxiq',
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        this.setData({
          questions: res.data.data.problems
        })
      },
      fail: err => {
        console.log(err)
      }
    })
    this.setData({
      infoData: JSON.parse(wx.getStorageSync('infoData'))
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

  getValue(e: any) {
    try {
      let temp: Array<{id?: string, type?: number, data?: string, options_id?: string}> = this.data.answers
      temp[parseInt(e.detail.id)] = {
        id: e.detail.id,
        type: e.detail.type,
        options_id: e.detail.event.detail,
      }
      this.setData({
        // @ts-ignore
        answers: temp
      })
    } catch (error) {
      console.log(error)
    }
  },

  submitQuestion () {
    if (this.data.answers.length === 0) {
      Toast.fail('请填写表单！')
      return
    }
    for (let i = 1; i < this.data.answers.length; i++) {
      if (this.data.answers[i] === undefined) {
        Toast.fail('表单不完整！')
        return
      }
    }
    // 提交表单
    const { weight, height, favoriteTea, teaAge, lifeIn, growthIn, professional } = this.data.infoData
    const data = {
      problem: this.data.answers.slice(1),
      info: { weight, height, favoriteTea, teaAge, lifeIn, growthIn, professional }
    }
    wx.cloud.callContainer({
      path: '/api/survey/submit',
      method: 'POST',
      data: data,
      header: {
        'Authorization': wx.getStorageSync('token'),
        'X-WX-SERVICE': 'springboot-cxiq',
        'content-type': 'application/json' // 默认值
      },
      success: res => {
        const resData: Array<{id: String, name: String, result: Number}> = res.data.data.list
        wx.navigateTo({
          url: '/pages/recommend/recommend?bodyArr=' + JSON.stringify(resData)
        })
      },
      fail: err => {
        console.log('error', err)
      }
    })
  }
})