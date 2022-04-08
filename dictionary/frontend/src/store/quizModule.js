export default {
	namespaced: true,
	state: {
		currentIndex: 0
	},
	mutations: {
		setCurrentIndex(state, index) {
			state.currentIndex = index
		},
		incrementCurrentIndex(state) {
			state.currentIndex = state.currentIndex + 1
		}
	}
}