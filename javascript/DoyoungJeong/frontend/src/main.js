import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//import vuetify from './plugins/vuetify'
import GlobalComponent from './components/GlobalComponent.vue'

const app = createApp(App)
app.component(GlobalComponent.name, GlobalComponent).use(store).use(router).mount('#app')


// new Vue ({
//     router,
//     store,
//     vuetify,
//     render: h => h(App)
// }).$mount('#app')