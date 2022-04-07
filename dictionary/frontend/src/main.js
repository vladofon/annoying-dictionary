import { createApp } from 'vue'
import directives from '@/directives/index'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from '@/router/index'
import store from '@/store/index'
import { loadFonts } from './plugins/webfontloader'

loadFonts()

const app = createApp(App)

directives.forEach(directive => {
	app.directive(directive.name, directive)
})

app
.use(store)
.use(router)
.use(vuetify)
.mount('#app')
