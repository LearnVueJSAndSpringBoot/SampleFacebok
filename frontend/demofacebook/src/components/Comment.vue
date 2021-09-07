<template>
  <div id="comment">
      
  </div>
</template>

<script>

export default {
  name: 'Comment',
  props: {
    dataListComment: {
      type: Array,
      require: true,
      default: () => [],
    },
  },
}
</script>

<style>

</style>
