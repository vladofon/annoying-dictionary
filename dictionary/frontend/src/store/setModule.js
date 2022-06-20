import DialogModes from '@/components/set/misc/DialogModes'

export default {
	namespaced: true,
	state: {
		sets: [
			{id: 1, title: 'Headline 1', description: 'Greyhound divisely hello coldly fonwderfully', stars: 5},
			{id: 2, title: 'Headline 2', description: 'Greyhound divisely hello coldly fonwderfully', stars: 0},
			{id: 3, title: 'Headline 3', description: 'Greyhound divisely hello coldly fonwderfully', stars: 12},
			{id: 4, title: 'Headline 4', description: 'Greyhound divisely hello coldly fonwderfully', stars: 62},
			{id: 5, title: 'Headline 5', description: 'Greyhound divisely hello coldly fonwderfully', stars: 165},
			{id: 6, title: 'Headline 6', description: 'Greyhound divisely hello coldly fonwderfully', stars: 18},
			{id: 7, title: 'Headline 7', description: 'Greyhound divisely hello coldly fonwderfully', stars: 12},
			{id: 8, title: 'Headline 8', description: 'Greyhound divisely hello coldly fonwderfully', stars: 1},
			{id: 9, title: 'Headline 9', description: 'Greyhound divisely hello coldly fonwderfully', stars: 11},
			{id: 10, title: 'Headline 10', description: 'Greyhound divisely hello coldly fonwderfully', stars: 19},
			{id: 11, title: 'Headline 11', description: 'Greyhound divisely hello coldly fonwderfully', stars: 2},
			{id: 12, title: 'Headline 12', description: 'Greyhound divisely hello coldly fonwderfully', stars: 12},
			{id: 13, title: 'Headline 13', description: 'Greyhound divisely hello coldly fonwderfully', stars: 42},
			{id: 14, title: 'Headline 14', description: 'Greyhound divisely hello coldly fonwderfully', stars: 3},
			{id: 15, title: 'Headline 15', description: 'Greyhound divisely hello coldly fonwderfully', stars: 56},
		],
		operableSet: {
			id: null,
			title: '',
			description: ''
		},
		dialogMode: DialogModes.CREATE
	},
	getters: {
		sortedByStarsSets(state) {
			return [...state.sets].sort((a,b) => b.stars - a.stars)
		}
	},
	mutations: {
		removeSet(state, id) {
			state.sets = state.sets.filter(item => item.id !== id)
		},
		addSet(state, set) {
			state.sets.push(set)
		},
		updateSet(state, set) {
			const index = state.sets.findIndex(item => item.id === set.id)
			
			state.sets.splice(index, 1, set)
		},
		setOperableSet(state, set) {
			state.operableSet = set
		},
		setDialogMode(state, mode) {
			state.dialogMode = mode
		}
	}
}