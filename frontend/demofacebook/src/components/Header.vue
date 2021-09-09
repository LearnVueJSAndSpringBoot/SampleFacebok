<template>
  <div class="Header">
    <a-layout-header id="components-layout-demo-top">
      <a-menu
        theme="light"
        mode="horizontal"
        :default-selected-keys="['1']"
        :style="{ lineHeight: '76px' }"
      >
        <a-menu-item key="1">
          <span
            ><router-link :to="{ name: 'home' }"
              ><a-badge :count="99" :overflow-count="10"
                ><a-avatar
                  src="https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1"
                  :size="55" /></a-badge></router-link
          ></span>
        </a-menu-item>
        <a-menu-item key="2">
          <span>
            <a-avatar
              src="https://play-lh.googleusercontent.com/I6iR-zi371fJJsGnqwnY8uUmeYqv-_erzVbVBhyASixDReX2JUuIhgXjtV9OrA-_nQI"
              :size="50"
            />
          </span>
        </a-menu-item>
        <a-menu-item key="3">
          <Add />
        </a-menu-item>
      </a-menu>
    </a-layout-header>
  </div>
</template>

<script>
import Add from "@/components/Add.vue";
export default {
  name: "Header",
  components: {
    Add,
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#components-layout-demo-top .ant-menu.ant-menu-dark .ant-menu-item-selected,
.ant-menu-submenu-popup.ant-menu-dark .ant-menu-item-selected {
  background-color: #fff;
}

#components-layout-demo-top {
  background-color: #fff;
  height: 77.5px;
}
</style>
header