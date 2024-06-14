<template>
  <div id="app">
    <router-view v-if="isRouterAlive" />
  </div>
</template>
<script>
export default {
  provide() {
    return {
      reload: this.reload,
      _beforeUnload_time: '',
      _gap_time: ''
    };
  },
  data() {
    return {
      isRouterAlive: true,
    };
  },
  methods: {
    reload() {
      this.isRouterAlive = false;
      this.$nextTick(function () {
        this.isRouterAlive = true;
      });
    },
  },
  //问题1已解决
  mounted() {
    window.addEventListener('beforeunload', (e) => {
      this._beforeUnload_time = new Date().getTime()
      console.log(this._beforeUnload_time, 'this._beforeUnload_time')
    })
    window.addEventListener('unload', () => {
      this._gap_time = new Date().getTime() - this._beforeUnload_time
      console.log(this._gap_time, 'ssss', new Date().getTime(), this._beforeUnload_time)
      if (this._gap_time <= 5) {
        //关闭
        localStorage.removeItem('token')
      } else {
        // 刷新
      }
    })
  },
  destroyed() {
    window.removeEventListener('beforeunload')
    window.removeEventListener('unload')
  }
  //问题1已解决
  // mounted(){
  //           // 关闭浏览器窗口的时候清空浏览器缓存在localStorage的数据
  //           window.onbeforeunload = function (e) {
  //               var storage = window.localStorage;
  //               storage.clear()
  //           }
            
  //       }
};
</script>
<style lang="less">
#app{
  height: 100%;
  background: #f9f9f9;
}
</style>
