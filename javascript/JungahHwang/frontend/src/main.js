import { createApp } from 'vue'
// import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// import vuetify from './plugins/vuetify'
import GlobalComponent from './components/GlobalComponent.vue'

// createApp(): vue 객체 생성
const app = createApp(App)

// vue 객체를 생성하는 중앙(main)에서 사용할 컴포넌트의 등록도 처리
// app.component(컴포넌트 이름, 컴포넌트 객체)
app.component(GlobalComponent.name, GlobalComponent)
.use(store).use(router).mount('#app')

