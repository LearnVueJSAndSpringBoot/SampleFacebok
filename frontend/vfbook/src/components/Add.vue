<template>
  <div class="add">
    <a-avatar
      src="https://www.pngfind.com/pngs/m/221-2214644_button-add-icon-web-symbol-internet-website-add.png"
      :size="45"
      @click="showDrawer"
    />
    <a-drawer
      title="Add new status"
      :width="720"
      :visible="visible"
      :body-style="{ paddingBottom: '80px' }"
      @close="onClose"
    >
      <a-form :form="form" layout="vertical" hide-required-mark>
        <a-row :gutter="16">
          <a-col :span="24">
            <a-form-item>
              <a-row type="flex">
                <a-col flex="33px">
                  <a-avatar
                    src="https://i0.wp.com/tuzonagamer.com/wp-content/uploads/2020/05/WhatsApp-Image-2020-05-18-at-2.42.44-PM-1.jpeg?ssl=1"
                    :size="28"
                  />
                </a-col>
                <a-col flex="auto">
                  <h3>Trần Vũ Trường</h3>
                </a-col>
              </a-row>
              <a-textarea
                style="height: 400px"
                v-decorator="[
                  'description',
                  {
                    rules: [
                      {
                        required: true,
                        message: 'Please enter your mind',
                      },
                    ],
                  },
                ]"
                :rows="4"
                placeholder="What's on your mind?"
              />
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
      <div
        :style="{
          position: 'absolute',
          right: 0,
          bottom: 0,
          width: '100%',
          borderTop: '1px solid #e9e9e9',
          padding: '10px 16px',
          background: '#fff',
          textAlign: 'right',
          zIndex: 1,
        }"
      >
        <a-button :style="{ marginRight: '8px' }" @click="onClose">
          Cancel
        </a-button>
        <a-button type="primary" @click="onClose"> Post </a-button>
      </div>
    </a-drawer>
  </div>
</template>

<script>
export default {
  name: "Add",
  data() {
    return {
      form: this.$form.createForm(this),
      visible: false,
    };
  },
  methods: {
    showDrawer() {
      this.visible = true;
    },
    onClose() {
      this.visible = false;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
