<template>
  <div id="postlist">
    <div v-for="(item, index) in dataPostList" :key="index">
      {{ index }}
      <Comment :dataListComment="item.commentVOS" />
    </div>
  </div>
</template>

<script>
import Comment from "@/components/Comment.vue";
export default {
  name: "PostList",
  components: {
    Comment,
  },
  props: {
    dataPostList: {
      type: Array,
      require: true,
      default: () => [],
    },
  },
};
</script>

<style>
</style>
