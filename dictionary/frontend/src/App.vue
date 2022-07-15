<template>
	<v-app class="app"> 
		<app-bar /> 
		<v-main class="main"> 
			<router-view :key="$route.fullPath">
			
			</router-view>
		</v-main> 
		<app-footer/>
	</v-app>
</template>

<script>
import AppBar from '@/components/AppBar.vue'
import AppFooter from '@/components/AppFooter.vue'
import { mapGetters, mapActions } from 'vuex'

export default {
	name: 'App',
	components: {
	AppBar,
	AppFooter,
	},
	computed: {
		...mapGetters('profile', ['profile', 'isAuthenticated'])
	},
	methods: {
		...mapActions('profile', ['fetchUser']),
		
		checkUserExisting() {
			if(typeof this.profile.id === "undefined") {
				return false
			}
			
			return true
		},
	},
	created() {
		if(!this.isAuthenticated) {
			this.fetchUser()
		}
	}
}
</script>

<style>
	.main {
		background-color: #f0f0f0;
	}
	body {
		background-color: teal;
	}
</style>
