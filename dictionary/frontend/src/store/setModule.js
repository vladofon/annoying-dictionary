import DialogModes from '@/components/set/misc/DialogModes'
import setApi from '@/api/set'

export default {
	namespaced: true,
	state: {
		sets: [],
		operableSet: {
			id: null,
			title: '',
			description: ''
		},
		dialogMode: DialogModes.CREATE
	},
	getters: {
		sets(state) {
			return [...state.sets].sort((a,b) => a.id - b.id)
		},
		sortedByStarsSets(state) {
			return [...state.sets].sort((a,b) => b.stars - a.stars)
		}
	},
	mutations: {
		setSets(state, sets) {
			state.sets = sets
		},
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
	},
	actions: {
		async fetchSets({commit}) {
			try {
				const response = await setApi.list()
				commit('setSets', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async fetchSet({commit}, id) {
			try {
				const response = await setApi.get(id)
				commit('setSets', [response.data])
				
			} catch (e) {
				console.log(e)
			}
		},
		async createSet({commit}, set) {
			try {
				const response = await setApi.create(set)
				commit('addSet', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async editSet({commit}, set) {
			try {
				const response = await setApi.edit(set)
				commit('updateSet', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async deleteSet({commit}, id) {
			try {
				await setApi.delete(id)
				commit('removeSet', id)
			} catch (e) {
				console.log(e)
			}
		}
	}
}