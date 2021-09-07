<template>
  <div id="postlist">
    <div v-for="(post, index) in dataPostList" :key="index">
      <a-row type="flex">
        <a-col flex="33px">
          <a-avatar
            src="https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1"
            :size="54"
          />
        </a-col>
        <a-col flex="auto">
          <h2>{{ post.user }}</h2>
          <h2>{{ post.timePost }}</h2>
        </a-col>
      </a-row>
      <br />
      <h3 class="text-overflow" refs="input">
        {{ post.contentPost }}
        <a class="btn-overflow" href="#">...Show more</a>
      </h3>
      <viewer :images="post.image">
        <img
          class="img-content"
          src="https://lh3.googleusercontent.com/proxy/GScOkIfUGZa9jZmG_gB_aqdcTi435Qxno09lBPksSWZbn7mvXDGIk7HM9LaiUfXPkL1lsdh0tQv6QNMfNUHRJXSJ7DFXQjGzCvaBoA2posO8VLaQaO_AjtlK83QV7GxEeIRkwqAO-lsnEljeYUCJ2O8KzCfmNOE2JjrWuySYXJ-beAvGt6p2G6j5vIY2gL-NvkRe-Bh7"
        />
      </viewer>
      <br />
      <br />
      <a-input-search
        placeholder="Write a comment"
        size="small"
        style="width: 300px"
      >
        <template #enterButton>
          <a-button>SEND</a-button>
        </template>
      </a-input-search>
      <br />
      <br />
      <input @keyup.enter="submit(item.id)" v-model="dataComment" />
      <Comment :dataListComment="item.commentVOS" :idPost="item.id" />
    </div>
  </div>
</template>

<script>
import Comment from "@/components/Comment.vue";
import commentaxios from "@/api/comment.js";
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
  data() {
    return {
      dataComment: "",
      formComment: {
        idPost: 0,
        level: 0,
        content: "",
        idParentComment: 0,
      },
    };
  },
  methods: {
    submit(idPost) {
      this.formComment.idPost = idPost;
      this.formComment.level = 1;
      this.formComment.content = this.dataComment;
      this.formComment.idParentComment = 0;
      this.insertComment();
    },
    async insertComment() {
      await commentaxios
        .insertComment(this.formComment)
        .then(this.$router.go());
    },
  },
};
</script>

<style></style>
