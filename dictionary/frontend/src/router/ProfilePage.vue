<template>
	<profile-form/>
	<profile-dialog/>
	<profile-header/>
	<app-header :center="true">Popular sets</app-header>
	<set-list/>
</template>

<script>
	import ProfileHeader from "@/components/profile/ProfileHeader.vue"
	import ProfileDialog from "@/components/profile/ProfileDialog.vue"
	import ProfileForm from "@/components/profile/ProfileForm.vue"
	import SetList from "@/components/set/SetList.vue"
	import AppHeader from "@/components/AppHeader.vue"
	
	export default {
		components: {
			ProfileForm,
			ProfileHeader,
			ProfileDialog,
			SetList,
			AppHeader
		}
	}
</script>