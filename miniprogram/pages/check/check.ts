// pages/check/check.ts
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';

Page({

  /**
   * 页面的初始数据
   */
  data: {
    data: [{
      id: 'sadasdas3242342asas',
      name: '平和质 (A型)',
      describe: '阴阳气血调和，以体态适中、面色红润、精力充沛等为主要特征。面色、肤色润泽，头发稠密有光泽，目光有神，鼻色明润，嗅觉通利，唇色红润，不易疲劳，精力充沛。'
    }, {
      id: 'asdasdwerewer',
      name: '气虚质 (B型)',
      describe: '元气不足，以疲乏、气短、自汗等气虚表现为主要特征。平素语音低弱，气短懒言，容易疲乏，精神不振，易出汗，舌淡红，舌边有齿痕，脉弱。'
    }, {
      id: 'xcvxcvfdh3454363',
      name: '阳虚质 (C型)',
      describe: '阳气不足，以畏寒怕冷、手足不温等虚寒表现为主要特征。平素畏冷，手足不温，喜热饮食，精神不振，舌淡胖嫩，脉沉迟。'
    }, {
      id: 'asdase534534tttwss',
      name: '阴虚质 (D型)',
      describe: '阴液亏少，以口燥咽干、手足心热等虚热表现为主要特征。手足心热，口燥咽干，鼻微干，喜冷饮，大便干燥，舌红少津，脉细数。'
    }, {
      id: 'asdsasdff',
      name: '痰湿质 (E型)',
      describe: '痰湿凝聚，以形体肥胖、腹部肥满、口黏苔腻等痰湿表现为主要特征。面部皮肤油脂较多，多汗且黏，胸闷，痰多，口黏腻或甜，喜食肥甘甜黏，苔腻，脉滑。'
    }, {
      id: 'sdfsdfsd534',
      name: '湿热质 (F型)',
      describe: '湿热内蕴，以面垢油光、口苦、苔黄腻等湿热表现为主要特征。面垢油光，易生痤疮，口苦口干，身重困倦，大便黏滞不畅或燥结，小便短黄。'
    }, {
      id: 'sdfsdfer5345',
      name: '血瘀质 (G型)',
      describe: '血行不畅，以肤色晦黯、舌质紫黯等血瘀表现为主要特征。肤色晦黯，色素沉着，容易出现瘀斑，口唇黯淡，舌黯或有瘀点，舌下络脉紫黯或增粗，脉涩。'
    }, {
      id: 'adfsdfsd4534',
      name: '气郁质 (H型)',
      describe: '气机郁滞，以神情抑郁、忧虑脆弱等气郁表现为主要特征。神情抑郁，情感脆弱，烦闷不乐，舌淡红，苔薄白，脉弦。'
    }, {
      id: 'sdfsdfsdfsd3432576',
      name: '特禀质 (I型)',
      describe: '先天失常，以生理缺陷、过敏反应等为主要特征。过敏体质者常见哮喘、风团、咽痒、鼻塞、喷嚏等。'
    }],
    loading: true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    Toast.loading({
      message: '加载中...',
      forbidClick: true,
    });
    wx.cloud.callContainer({
      path: '/api/bodyType',
      method: 'GET',
      header: {
        "X-WX-SERVICE": "springboot-cxiq",
        "content-type": "application/json"
      },
      success: res => {
        const resData = res.data.data
        this.setData({
          data: resData,
          loading: false
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

  }
})