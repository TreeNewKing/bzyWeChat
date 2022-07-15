// components/userinfoinput/userinfoinput.ts
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    optional: {
      type: Boolean,
      value: false
    },
    title: {
      type: String,
      value: ''
    },
    message: {
      type: String,
      value: ''
    },
    value: {
      type: String,
      value: ''
    },
    disable: {
      type: Boolean,
      value: false
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

    // 输入框内内容改变时将其传给父组件
    onChange: function (e: any) {
      this.triggerEvent('submitInputValue', e.detail)
    }
  }
})
