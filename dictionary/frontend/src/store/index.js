import { createStore } from 'vuex'


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

  }
})
