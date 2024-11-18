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

library.add(faUserSecret, faCoffee);

const app = createApp(App);
// app.use(ElementPlus);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus);
app.component('font-awesome-icon', FontAwesomeIcon);
app.mount("#app");