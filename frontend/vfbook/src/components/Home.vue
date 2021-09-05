<template>
  <div class="home">
      <PostList />
  </div>
</template>

<script>
import PostList from "@/components/PostList.vue";

export default {
  name: "Home",
  data() {
    return {
      dataHome : [
        {postHome: PostList, cmHome: Comment }
      ]
    }
  },
  components: {
    PostList
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
