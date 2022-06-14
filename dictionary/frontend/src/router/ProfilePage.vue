<template>
	<profile-header/>
	<set-list/>
</template>

<script>
	import ProfileHeader from "@/components/profile/ProfileHeader.vue"
	import SetList from "@/components/profile/SetList.vue"
	
	export default {
		components: {
			ProfileHeader,
			SetList
		}
	}
</script>