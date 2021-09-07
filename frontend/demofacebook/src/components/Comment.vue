<template>
  <div id="comment">
    <a-row type="flex">
      <a-col flex="33px">
        <a-avatar
          src="https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1"
          :size="40"
        />
      </a-col>
      <a-col flex="auto">
        <h5>{{ dataListComment.user }} - {{ dataListComment.timeComment }}</h5>
        <h5>{{ dataListComment.content }}</h5>
        <h4></h4>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: "Comment",
  props: {
    dataListComment: {
      type: Array,
      require: true,
      default: () => [],
    },
  },
};
</script>

<style>
</style>
