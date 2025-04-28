import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from "./router"
import elementIcon from "./plugins/icon"
createApp(App).use(router).use(elementIcon).mount('#app')
