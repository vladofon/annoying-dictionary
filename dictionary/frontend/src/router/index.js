import { createRouter, createWebHistory } from 'vue-router'
import WordsPage from '@/router/WordsPage.vue'
import SetsPage from '@/router/SetsPage.vue'
import QuizPage from '@/router/QuizPage.vue'
import SetPage from '@/router/SetPage.vue'
import ProfilePage from '@/router/ProfilePage.vue'

const routes = [
  {path: '/words', component: WordsPage},
  {path: '/sets', component: SetsPage},
  {path: '/sets/:id', component: SetPage},
  {path: '/quiz', component: QuizPage},
  {path: '/profile', component: ProfilePage},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
