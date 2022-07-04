import profileApi from '@/api/profile'

export default {
	namespaced: true,
	state: {
		profile: {},
		localProfile: {}
	},
	getters: {
		isAuthenticated(state) {
			return (Object.keys(state.profile).length !== 0) ? true : false
		}
	},
	mutations: {
		updateProfile(state, profile) {
			state.profile = {...profile}
			state.localProfile = {...profile}
		},
		loadLocalProfile(state) {
			state.localProfile = {...state.profile}
		}
	},
	actions: {
		async fetchUser({commit}) {
			try {
				const response = await profileApi.get()
				commit('updateProfile', response.data)
			} catch (e) {
				console.log(e)
			}
		}
	}
}