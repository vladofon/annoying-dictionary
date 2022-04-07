import { createStore } from 'vuex'
import wordModule from '@/store/wordModule'
import setModule from '@/store/setModule'

export default createStore({
  state: {
		isDialogActive: false,
  },
  getters: {
  },
  mutations: {
		switchDialog(state, dialog) {
			state.isDialogActive = dialog;
		}
  },
  actions: {
  },
  modules: {
		word: wordModule,
		set: setModule
  }
})
