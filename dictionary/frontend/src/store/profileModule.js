export default {
	namespaced: true,
	state: {
		profile: {
			name: 'Marcus Obrien',
			avatar: 'https://cdn.vuetifyjs.com/images/profiles/marcus.jpg',
			status: 'Free'
		},
		localProfile: {
			name: 'Marcus Obrien',
			avatar: 'https://cdn.vuetifyjs.com/images/profiles/marcus.jpg',
			status: 'Free'
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
	}
}