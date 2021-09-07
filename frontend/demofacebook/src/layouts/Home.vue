<template>
  <div id="home">
    <Header />
    <PostList :dataPostList="listPost" />
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import PostList from "@/components/PostList.vue";
// import axios from "axios";
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
      console.log(this.listPost);
    },
  },

created() {
    console.log("demno");
    this.getDataPost();
  },
};
</script>

<style>
</style>
