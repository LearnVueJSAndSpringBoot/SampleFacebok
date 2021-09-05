<template>
  <div id="app">
    <a-layout id="components-layout-demo-top" class="layout">
      <Header/>
      <a-layout-content style="padding: 0 300px">
        <div
          :style="{
            background: '#fff',
            padding: '50px',
            minHeight: '650px',
            margin: '16px 0',
          }"
        >
          <router-view />         
        </div>
      </a-layout-content>
    </a-layout>
  </div>
</template>

<script>
import Header from "@/layouts/Header.vue";
export default {
  name: "App",
  components: {
    Header,
  },
};
</script>

<style>

</style>
