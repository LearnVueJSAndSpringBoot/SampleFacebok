<template>
  <div id="home">
    <Header />
    <a-layout-content style="padding: 0 300px">
      <div
        :style="{
          background: '#fff',
          padding: '50px',
          minHeight: '650px',
          margin: '16px 0',
        }"
      >
        <PostList :dataPostList="listPost" />
      </div>
    </a-layout-content>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import PostList from "@/components/PostList.vue";
import home from "@/api/home.js";
export default {
  name: "Home",
  components: {
    Header,
    PostList,
  },
  data() {
    return {
      listPost: [],
    };
  },

  methods: {
    async getDataPost() {
      let post = await home.getDataHome();
      this.listPost = post.data.data;
    },
  },

  created() {
    this.getDataPost();
  },
};
</script>

<style>
</style>
