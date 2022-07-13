import { createRouter, createWebHistory } from 'vue-router'
import MainPage from '@/router/MainPage.vue'
import WordsPage from '@/router/WordsPage.vue'
import WordSearchPage from '@/router/WordSearchPage.vue'
import SetsPage from '@/router/SetsPage.vue'
import QuizPage from '@/router/QuizPage.vue'
import SetPage from '@/router/SetPage.vue'
import ProfilePage from '@/router/ProfilePage.vue'
import SearchPage from '@/router/SearchPage.vue'

const routes = [
  {path: '/', component: MainPage},
  {path: '/words', component: WordsPage},
  {path: '/words/find/:value', component: WordSearchPage},
  {path: '/sets', component: SetsPage},
  {path: '/sets/:id', component: SetPage},
  {path: '/quiz/:id', component: QuizPage},
  {path: '/profile', component: ProfilePage},
  {path: '/search/:value', component: SearchPage},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
