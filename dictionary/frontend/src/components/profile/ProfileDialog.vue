<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">Edit profile</span>
		</template>
		<v-text-field v-model="localProfile.name" autofocus label="Name" variant="filled" color="teal"></v-text-field>
		<v-textarea
			v-model="localProfile.avatar"
			rounded
			color="teal"
			class="bg-grey-lighten-3 pa-3 px-6 mt-n5"
			variant="plain"
			name="input-7-4"
			label="Description"
			placeholder="Enter some description..."
		>
		</v-textarea>
		<template v-slot:dialog-actions>
			<v-btn @click="editProfile" color="teal" text>
				Edit
			</v-btn>
		</template>
	</app-dialog>
</template>

<script>
	import AppDialog from '@/components/AppDialog.vue'
	import { mapMutations } from 'vuex'
	
	export default {
		components: {
			AppDialog
		},
		computed: {
			localProfile: {
				get() {
					return this.$store.state.profile.localProfile
				},
				set() {
					
				}
			},
		},
		methods: {
			...mapMutations('profile', ['updateProfile']),
			...mapMutations(['switchDialog']),

			editProfile() {
				this.updateProfile(this.localProfile)
				this.switchDialog(false)
			}
		}
	}
</script>