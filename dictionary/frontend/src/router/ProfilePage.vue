<template>
	<profile-form/>
	<profile-dialog/>
	<profile-header/>
	<div v-if="sortedByStarsSets">
		<app-header :center="true">Popular sets</app-header>
		<set-list :sets="sortedByStarsSets"/>
	</div>
</template>

<script>
	import ProfileHeader from "@/components/profile/ProfileHeader.vue"
	import ProfileDialog from "@/components/profile/ProfileDialog.vue"
	import ProfileForm from "@/components/profile/ProfileForm.vue"
	import SetList from "@/components/set/SetList.vue"
	import AppHeader from "@/components/AppHeader.vue"
	import { mapGetters, mapActions } from 'vuex'
	
	export default {
		components: {
			ProfileForm,
			ProfileHeader,
			ProfileDialog,
			SetList,
			AppHeader
		},
		computed: {
			...mapGetters('set', ['sortedByStarsSets']),
			...mapGetters('profile', ['profile']),
		},
		methods: {
			...mapActions('set', ['fetchUserSets']),
		},
		watch: {
			profile(newProfile) {
				this.fetchUserSets(newProfile.id)
			}
		}
	}
</script>