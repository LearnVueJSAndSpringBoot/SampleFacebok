<template>
  <div v class="PostList">
    <div v-for="(post, index) in topPost" :key="index">
      <a-row type="flex">
        <a-col flex="33px">
          <a-avatar :src="post.avatar" :size="54" />
        </a-col>
        <a-col flex="auto">
          <h2>{{ post.name }}</h2>
          <h2>{{ post.timeCreatePost }}</h2>
        </a-col>
      </a-row>
      <br />
      <h3 class="text-overflow" refs="input">
        {{ post.contentPost }}
        <a class="btn-overflow" href="#">...Show more</a>
      </h3>
      <viewer :images="post.image">
        <img class="img-content" :src="post.image" />
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
      <Comment
        v-for="(com, index) in post.comment"
        :key="index"
        :userData="com"
      />
      <br />
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
  data() {
    return {
      topPost: [
        {
          idPost: "1",
          name: "Trần Vũ Trường",
          avatar:
            "https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1",
          timeCreatePost: "22:00",
          image: "https://ting3s.com/uploads/images/202012/44.jpg",
          contentPost:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
          comment: [
            {
              idComment: "1",
              content: "Hay qua",
              time: "22:10",
              username: "Lê Thị Ngọc",
              avatar:
                "https://play-lh.googleusercontent.com/ngwuUc0RUgI_sLPhPvGWsxhwujbYL5yS-T5j4H32bWbf_Kow_6qn2NmgxCHXWvW_Nx8",
              level: "1",
              subComment: [
                {
                  content:
                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                  time: "5:00",
                  username: "Lê Thị Ngọc",
                  avatar:
                    "https://play-lh.googleusercontent.com/ngwuUc0RUgI_sLPhPvGWsxhwujbYL5yS-T5j4H32bWbf_Kow_6qn2NmgxCHXWvW_Nx8",
                  level: "2",
                },
              ],
            },
            {
              content: "Dang cap qua, khong con gi de noi",
              time: "6:00",
              username: "Trần Bình Minh",
              avatar:
                "https://phongvu.vn/cong-nghe/wp-content/uploads/2020/05/14.png",
              level: "1",
            },
          ],
        },
        {
          idPost: "2",
          name: "Nguyễn Hữu Lâm Phong",
          avatar:
            "https://www.nj.com/resizer/zovGSasCaR41h_yUGYHXbVTQW2A=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/SJGKVE5UNVESVCW7BBOHKQCZVE.jpg",
          image:
            "https://i.pinimg.com/originals/66/c1/73/66c1735c6382d26e52e46a17809d8038.jpg",
          timeCreatePost: "21:00",
          contentPost:
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
          comment: [
            {
              idComment: "2",
              content: "Vo tay, vo tay",
              time: "22:10",
              username: "Trần Vũ Trường",
              avatar:
                "https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1",
              level: "1",
              subComment: [
                {
                  content:
                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                  time: "5:00",
                  username: "Lê Thị Ngọc",
                  avatar:
                    "https://play-lh.googleusercontent.com/ngwuUc0RUgI_sLPhPvGWsxhwujbYL5yS-T5j4H32bWbf_Kow_6qn2NmgxCHXWvW_Nx8",
                  level: "2",
                },
              ],
            },
            {
              content: "Dang cap qua, khong con gi de noi",
              time: "6:00",
              username: "Tran Bình Minh",
              avatar:
                "https://phongvu.vn/cong-nghe/wp-content/uploads/2020/05/14.png",
              level: "1",
            },
          ],
        },
      ],
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h2 {
  margin: 0px;
}

h3 {
  text-align: justify;
  letter-spacing: 1px;
}

img {
  height: 400px;
  width: 800px;
}
</style>
