import { createApp } from "vue";
import App from "./App.vue";
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import 'element-plus/dist/index.css';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faUserSecret, faCoffee } from '@fortawesome/free-solid-svg-icons';
// import "~/styles/element/index.scss";

import ElementPlus from "element-plus";
// import all element css, uncommented next line

// or use cdn, uncomment cdn link in `index.html`

import "~/styles/index.scss";
import "uno.css";

// If you want to use ElMessage, import it.
import "element-plus/theme-chalk/src/message.scss";

import router from './router'
import { createPinia } from 'pinia'; // 导入 Pinia
library.add(faUserSecret, faCoffee);

const app = createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus);
app.use(router);

// 创建并使用 Pinia store
const pinia = createPinia();
app.use(pinia);

app.component('font-awesome-icon', FontAwesomeIcon);

// 挂载整个应用到app容器中
app.mount("#app");