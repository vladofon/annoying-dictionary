<template>
	<profile-form />
	<profile-header/>
	
	<v-container fluid class="bg-teal ">
		<v-row>
			<v-col class="d-flex justify-center">
				<h3 class="text-white text-center">Popular sets</h3>
			</v-col>
		</v-row>
	</v-container>
	
	<set-list/>
</template>

<script>
	import ProfileHeader from "@/components/profile/ProfileHeader.vue"
	import ProfileForm from "@/components/profile/ProfileForm.vue"
	import SetList from "@/components/set/SetList.vue"
	
	export default {
		components: {
			ProfileForm,
			ProfileHeader,
			SetList
		}
	}
</script>