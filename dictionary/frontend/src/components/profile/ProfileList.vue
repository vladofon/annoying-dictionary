<template>
	<v-container class="pa-3">
		<v-row>
			<v-col cols="4">
				<profile-card />
			</v-col>
			<v-col cols="4">
				<profile-card />
			</v-col>
			<v-col cols="4">
				<profile-card />
			</v-col>
			<v-col cols="4">
				<profile-card />
			</v-col>
			<v-col cols="4">
				<profile-card />
			</v-col>
			<v-col cols="4">
				<profile-card />
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
import ProfileCard from '@/components/profile/ProfileCard.vue'

export default {
	components: {
		ProfileCard
	}
}
</script>