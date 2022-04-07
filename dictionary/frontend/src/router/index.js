import { createRouter, createWebHistory } from 'vue-router'
import WordsPage from '@/router/WordsPage.vue'
import SetsPage from '@/router/SetsPage.vue'

const routes = [
  {path: '/words', component: WordsPage},
  {path: '/sets', component: SetsPage}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
