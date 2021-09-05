<template>
  <div class="Comment">
    <a-row type="flex">
      <a-col flex="33px">
        <a-avatar :src="userData.avatar" :size="40" />
      </a-col>
      <a-col flex="auto">
        <h5>{{ userData.username }} - {{ userData.time }}</h5>
        <h5>{{ userData.content }}</h5>
      </a-col>
    </a-row>
    <br />
  </div>
</template>

<script>
export default {
  name: "Comment",
  props: ["userData"],
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
