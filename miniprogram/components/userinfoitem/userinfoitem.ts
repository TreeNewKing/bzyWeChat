// components/userinfoitem/userinfoitem.ts
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    title: {
      type: String,
      value: ''
    },
    options: {
      type: Array,
      value: []
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    radio: ''
  },

  /**
   * 组件的方法列表
   */
  methods: {
    onChange: function(event: any) {
      this.setData({
        radio: event.detail
      })
      this.triggerEvent('submitRadio', event.detail)
    }
  },
})
