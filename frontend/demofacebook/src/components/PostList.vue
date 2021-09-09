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
      <h3 class="text-overflow" v-show="!flag">
        {{ post.contentPost | summary }}
        <a class="btn-overflow" @click="flag = true">...Show more</a>
      </h3>
      <section class="text-overflow" v-show="flag">
        <h3 v-html="post.contentPost"></h3>
        <a class="btn-overflow" @click="flag = false">Show less</a>
      </section>
      <img
        class="img-content"
        src="http://quangbaso.net/wp-content/uploads/2018/09/hinh-nen-may-tinh-4k-Su-Tu-trong-thien-nhien-hoang-da.jpg"
      />
      <br />
      <br />
      <a-input
        placeholder="Write a comment"
        @keyup.enter="submit(post.id)"
        v-model="dataComment"
      />
      <br />
      <br />
      <Comment :dataListComment="post.commentVOS" :idPost="post.id" />
      <br />
      <br />
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
      flag: false,
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
  filters: {
    summary: function (text) {
      return text.substring(0, 150);
    },
  },
};
</script>

<style scoped>
.img-content {
  height: 300px;
  width: 800px;
}
</style>
