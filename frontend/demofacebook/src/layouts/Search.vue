<template>
  <div id="search">
    <Header @search="checkEmit" />
    <a-layout-content style="padding: 0 300px">
      <div
        :style="{
          background: '#fff',
          padding: '50px',
          minHeight: '650px',
          margin: '16px 0',
        }"
      >
        <PostList :dataPostList="listSearch" />
      </div>
    </a-layout-content>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import PostList from "@/components/PostList.vue";
export default {
  name: "Search",
    components: {
    Header,
    PostList,
  },
    data() {
    return {
      listSearch: [],
    };
  },
    checkEmit(data){
       this.listSearch = data;
    }
};
</script>

<style>
</style>
