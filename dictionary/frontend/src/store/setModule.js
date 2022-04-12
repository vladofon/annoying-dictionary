export default {
	namespaced: true,
	state: {
		sets: [
			{id: 1, title: 'Headline 1', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 2, title: 'Headline 2', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 3, title: 'Headline 3', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 4, title: 'Headline 4', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 5, title: 'Headline 5', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 6, title: 'Headline 6', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 7, title: 'Headline 7', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 8, title: 'Headline 8', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 9, title: 'Headline 9', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 10, title: 'Headline 10', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 11, title: 'Headline 11', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 12, title: 'Headline 12', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 13, title: 'Headline 13', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 14, title: 'Headline 14', description: 'Greyhound divisely hello coldly fonwderfully'},
			{id: 15, title: 'Headline 15', description: 'Greyhound divisely hello coldly fonwderfully'},
		],
		createDialog: false,
		editDialog: false,
		editableSetIndex: -1, 
	},
	mutations: {
		removeSet(state, id) {
			state.sets = state.sets.filter(item => item.id !== id)
		},
		addSet(state, set) {
			state.sets.push(set)
		},
		editSet(state, set) {
			const index = state.sets.findIndex(item => item.id === set.id)
			
			state.sets.splice(index, 1, set)
		},
		setEditableSetIndex(state, index) {
			state.editableSetIndex = index
		} ,
		switchCreateDialog(state, dialog) {
			state.createDialog = dialog
		},
		switchEditDialog(state, dialog) {
			state.editDialog = dialog
		}
	}
}