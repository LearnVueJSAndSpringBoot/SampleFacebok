<template>
  <div id="comment">
    <div class="comment" v-for="(item, index) in dataListComment" :key="index">
      <!-- <div>=====================================================</div> -->
      <h1></h1>
      <div>{{ item.user }}</div>
      <div>{{ item.timeComment }}</div>
      <div>{{ item.content }}</div>
      <div @click="reply(item.user, index)">Phản hồi</div>
      <div
        v-if="item.commentVOS.length != 0 && !checkRender"
        @click="checkRender = !checkRender"
      >
        {{ item.commentVOS.length }} bình luận khác
      </div>
      <input
        v-if="checkInput && index == indexInput"
        @keyup.enter="submit(item.level, item.id)"
        v-model="dataComment"
      />
      <div v-if="item.commentVOS.length != 0 && checkRender">
        <Comment :dataListComment="item.commentVOS" :idPost="idPost" />
      </div>
    </div>
  </div>
</template>

<script>
import Comment from "@/components/Comment.vue";
import commentaxios from "@/api/comment.js";
export default {
,
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
.comment {
  background-color: antiquewhite;
}
</style>
