const observe = (obj: any, key: any, watchFun: any, deep: any, page: any) => {
  let oldVal = obj[key]
  // 如果监听对象是object类型并且指定deep（深度监听）
  if (oldVal !== null && typeof oldVal === 'object' && deep) {
    // 递归子集，依次执行observe()
    Object.keys(oldVal).forEach(item => {
      observe(oldVal, item, watchFun, deep, page)
    })
  }
  // 使用Object.defineProperty()劫持数据的写操作，在监听对象改变后执行传入的watchFun
  Object.defineProperty(obj, key, {
    configurable: true,
    enumerable: true,
    set(value) {
      if (value === oldVal) return
      watchFun.call(page, value, oldVal)
      oldVal = value
    },
    get() {
      return oldVal
    }
  })
}

export const setWatcher = (page: any) => {
  // 页面里的data字段
  const data = page.data
  // 页面里的watch字段
  const watch = page.watch
  // 对watch里列举的每一个字段（需要监听的字段）执行observe()
  Object.keys(watch).forEach(key => {
    let targetData = data
    const targetKey = key
    // 支持deep深度监听，使用deep时需要配合handler使用，否则直接编写函数
    const watchFun = watch[key].handler || watch[key]
    const deep = watch[key].deep
    observe(targetData, targetKey, watchFun, deep, page)
  })
}

// const getUserInfo = () => {
//   wx.getUserProfile({
//     // desc 声明获取用户个人信息后的用途，不超过30个字符
//     desc: '注册，登录小程序',
//     success: res => {
//       if (res.userInfo) {
//         /*  wx.login 调用接口获取登录凭证（code）。通过凭证进而换取用户登录态信息，包括用户在当前小程序的唯一标识（openid）、微信开放平台帐号下的唯一标识（unionid，若当前小程序已绑定到微信开放平台帐号）及本次登录的会话密钥（session_key）*/
//         wx.login({
//           success: ret => {
//             // 获取code
//             var code = ret.code;
//             // 获取用户昵称
//             var nickName = res.userInfo.nickName;
//             // 获取用户照片
//             var avatarUrl = res.userInfo.avatarUrl;
//             // 发送至后端
//             wx.cloud.callContainer({
//               path: '/api/user/login',
//               data: {
//                 code: code,
//                 nickName: nickName,
//                 avatarUrl: avatarUrl
//               },
//               method:"POST",
//               header: {
//                 'X-WX-SERVICE': 'springboot-cxiq',
//                 'content-type': 'application/json' // 默认值
//               },
//               // 数据返回
//               success (resp) {
//                 console.log('login resp', resp.data);
//                 // 将用户id储存于本地
//                 wx.setStorageSync('token', resp.data.data.token);
//                 // 将用户微信信息设置成小程序信息
//                 wx.setStorageSync('userName', res.userInfo.nickName)
//                 wx.setStorageSync('userAvatar', res.userInfo.avatarUrl)
//                 return true
//               }
//             })
//           }
//         })
//       }
//     },
//     fail: err => {
//       console.log('err', err)
//       return false
//     }
//   })
// }
