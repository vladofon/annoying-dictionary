<template>
	<app-header>People</app-header>
	<profile-list/>
</template>

<script>
import AppHeader from '@/components/AppHeader.vue'
import ProfileList from '@/components/profile/ProfileList.vue'

export default {
	components: {
		AppHeader,
		ProfileList,
	}
}
</script>