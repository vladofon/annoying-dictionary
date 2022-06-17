<template>
	<profile-form />
	<profile-header/>
	<app-header>Popular sets</app-header>
	<set-list/>
</template>

<script>
	import ProfileHeader from "@/components/profile/ProfileHeader.vue"
	import ProfileForm from "@/components/profile/ProfileForm.vue"
	import SetList from "@/components/set/SetList.vue"
	import AppHeader from "@/components/AppHeader.vue"
	
	export default {
		components: {
			ProfileForm,
			ProfileHeader,
			SetList,
			AppHeader
		}
	}
</script>