// components/bodycategory/bodycategory.ts
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    tag: {
      type: String,
      value: ''
    },
    desc: {
      type: String,
      value: ''
    },
    bodytype: {
      type: String,
      value: ''
    }
  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {
    navigateToDetail() {
      wx.navigateTo({
        url: '/pages/detail/detail?bodyType_id=' + JSON.stringify(this.data.bodytype) + '&body=' + JSON.stringify(this.data.tag) 
      })
    }
  }
})
