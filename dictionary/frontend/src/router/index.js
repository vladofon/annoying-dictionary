import { createRouter, createWebHistory } from 'vue-router'
import WordsPage from '@/router/WordsPage.vue'

const routes = [
  {path: '/words', component: WordsPage}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
