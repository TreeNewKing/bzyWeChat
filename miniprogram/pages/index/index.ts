// index.ts
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';

Page({
  data: {
    radioSex: '',
    message: '本项目旨在通过问卷的形式给你推荐一款适合您的茶叶！'
  },
  async onLoad() {
    const res = await wx.cloud.callContainer({
      config: {
        env: 'prod-9gpx0wysac930832'
      },
      path: '/hello',
      method: 'GET',
      header: {
        "X-WX-SERVICE": "springboot-cxiq"
      }
    })
    console.log(res)
  },
  async navigateToUser() {
    // 如果已经存在该用户的个人信息，则直接填表
    // const res = await wx.cloud.callContainer({
    //   path: '/survey/info',
    //   method: 'GET',
    //   header: {
    //     Authorization: ''
    //   }
    // })
    // if (res.data) {
    //   wx.navigateTo({
    //     url: '/pages/question/question'
    //   })
    // } else {
    //   wx.navigateTo({
    //     url: '/pages/userinfo/userinfo'
    //   })
    // }
    if (!this.validateLoginStatus()) {
      return
    }
    wx.navigateTo({
      url: '/pages/userinfo/userinfo'
    })
  },
  navigateToQuestion() {
    wx.navigateTo({
      url: '/pages/question/question'
    })
  },
  navigateToCheck() {
    wx.navigateTo({
      url: '/pages/check/check'
    })
  },
  navigateToBook() {
    wx.navigateTo({
      url: '/pages/book/book'
    })
  },
  onChangeSex(event: any) {
    this.setData({
      radioSex: event.detail,
    });
  },
  validateLoginStatus () {
    if (wx.getStorageSync('token') === '') {
      setTimeout(() => {
        wx.redirectTo({
          url: '/pages/login/login'
        })
      }, 1000)
      Toast.fail('请先登录！')
      return false
    }
    return true
  }
  // 退出登录
  // loginOut() {
  //   this.setData({
  //     userInfo: ''
  //   }),
  //   // 把user缓存存储为空
  //   wx.setStorageSync('user', '')
  // },
})
