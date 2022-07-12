import DialogModes from '@/components/word/misc/DialogModes'
import wordApi from '@/api/word'

export default {
	namespaced: true,
	state: {
		words: [],
		operableWord: {
			id: -1,
			setId: -1,
			value: '',
			context: ''
		},
		dialogMode: DialogModes.CREATE
	},
	getters: {
		words(state) {
			return state.words.sort((a,b) => a.id - b.id)
		}
	},
	mutations: {
		setWords(state, words) {
			state.words = words
		},
		removeWord(state, id) {
			state.words = state.words.filter(item => item.id !== id)
		},
		addWord(state, word) {
			state.words.push(word)
		},
		updateWord(state, word) {
			const index = state.words.findIndex(item => item.id === word.id)
			
			state.words.splice(index, 1, word)
		},
		setDialogMode(state, mode) {
			state.dialogMode = mode;
		},
		setOperableWord(state, word) {
			state.operableWord = word
		}
	},
	actions: {
		async fetchWords({commit}) {
			try {
				const response = await wordApi.list()
				commit('setWords', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async fetchByValue({commit}, value) {
			try {
				const response = await wordApi.getByValue(value)
				commit('setWords', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async createWord({commit}, word) {
			try {
				const response = await wordApi.create(word)
				commit('addWord', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async editWord({commit}, word) {
			try {
				const response = await wordApi.edit(word)
				commit('updateWord', response.data)
			} catch (e) {
				console.log(e)
			}
		},
		async deleteWord({commit}, id) {
			try {
				await wordApi.delete(id)
				commit('removeWord', id)
			} catch (e) {
				console.log(e)
			}
		}
	}
}