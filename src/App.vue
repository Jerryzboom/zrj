<template>
  <!-- 想跳成功必须加  -->
  <!-- <router-link to = "/">fafafa</router-link> -->
  <router-view>
  </router-view>
  <!-- <register></register> -->
  <!-- <AdminHomePage></AdminHomePage> -->
</template>

<script lang = "ts">
const debounce = (callback: (...args: any[]) => void, delay: number) => {
      let tid: any;
      return function (...args: any[]) {
        const ctx = self;
        tid && clearTimeout(tid);
        tid = setTimeout(() => {
          callback.apply(ctx, args);
        }, delay);
      };
    };

    const _ = (window as any).ResizeObserver;
    (window as any).ResizeObserver = class ResizeObserver extends _ {
      constructor(callback: (...args: any[]) => void) {
        callback = debounce(callback, 20);
        super(callback);
      }
    };
export default {
    name : "app",
    components : {
    },
    beforeCreate() {
      console.log("在创建之前")
    },
    created() {
      console.log("创建了")
    },
    beforeMount() {
      console.log("在渲染之前")
    },
    Mounted() {
      console.log("渲染了")
    },
    beforeUpdate() {
      console.log("在更新之前")
    },
    updated() {
      console.log("更新了")
    },
    beforeUnmount() {
      console.log("在卸载之前")
    },
    unmounted() {
      console.log("卸载了")
    }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
