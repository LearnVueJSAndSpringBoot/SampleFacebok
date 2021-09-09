<template>
  <div id="comment">
    <div class="comment" v-for="(item, index) in dataListComment" :key="index">
      <div class="subComment">
        <h4>
          <a-avatar
            src="https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1"
            :size="25"
          />
          {{ item.user }}
        </h4>
        <h6>{{ item.timeComment }}</h6>
        <h5>{{ item.content }}</h5>

        <h5 @click="reply(item.user, index)">Reply</h5>
        <h5
          v-if="item.commentVOS.length != 0 && !checkRender"
          @click="checkRender = !checkRender"
        >
          {{ item.commentVOS.length }} comments
        </h5>
        <a-input
          v-if="checkInput && index == indexInput"
          @keyup.enter="submit(item.level, item.id)"
          v-model="dataComment"
        />
        <div v-if="item.commentVOS.length != 0 && checkRender">
          <Comment :dataListComment="item.commentVOS" :idPost="idPost" />
        </div>
      </div>
      <br />
      <br />
    </div>
  </div>
</template>

<script>
import Comment from "@/components/Comment.vue";
import commentaxios from "@/api/comment.js";
export default {
  name: "Comment",
  components: {
    Comment,
  },
  props: {
    dataListComment: {
      type: Array,
      require: true,
      default: () => [],
    },
    idPost: {
      type: Number,
      require: true,
      default: 0,
    },
  },
  data() {
    return {
      indexInput: -1,
      checkInput: false,
      checkRender: false,
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
    reply(user, index) {
      this.checkInput = true;
      this.dataComment = user;
      this.indexInput = index;
    },
    submit(level, idParent) {
      this.formComment.idPost = this.idPost;
      this.formComment.level = level + 1;
      this.formComment.content = this.dataComment;
      this.formComment.idParentComment = idParent;
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

<style>
.subComment {
  border: 1px solid rgb(243, 239, 239);
  border-radius: 30px;
  padding: 10px;
  -webkit-box-shadow: 0px 0px 22px 26px rgba(237, 237, 237, 0.94);
  -moz-box-shadow: 0px 0px 22px 26px rgba(237, 237, 237, 0.94);
  box-shadow: 0px 0px 22px 26px rgba(237, 237, 237, 0.94);
}
</style>
