export default {
	namespaced: true,
	state: {
		isDialogActive: false,
	},
	mutations: {
		switchDialog(state, dialog) {
			state.isDialogActive = dialog;
		}
	}
}