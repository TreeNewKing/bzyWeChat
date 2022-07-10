Component({
  /**
   * 组件的属性列表
   */
  properties: {
    title: {
      type: String,
      value: ''
    },
    data: {
      type: Array,
      value: [{
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
    },
    idx: {
      type: String,
      value: ''
    },
    type: {
      type: Number,
      value: 0
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
      this.triggerEvent('submitValue', {id: this.data.idx, type: this.data.type, event: event})
    }
  },

  lifetimes: {

  },

  observer: {}
})
