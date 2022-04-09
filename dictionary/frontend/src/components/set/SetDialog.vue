<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">Create new set</span>
		</template>
		<v-text-field v-model="set.title" autofocus label="Name" variant="filled" color="teal"></v-text-field>
		<v-textarea
			v-model="set.description"
			rounded
			color="teal"
			class="bg-grey-lighten-3 pa-3 px-6 mt-n5"
			variant="plain"
			name="input-7-4"
			label="Description"
			placeholder="Enter some description..."
		></v-textarea>
		<template v-slot:dialog-actions>
			<v-btn @click="createSet" color="teal" text>
				Create
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
		data() {
			return {
				set: {
					title: '',
					description: ''
				}
			}
		},
		methods: {
			...mapMutations('set', ['addSet']),
			...mapMutations(['switchDialog']),
			createSet() {
				this.set.id = Math.floor(Math.random() * 100000)
				this.addSet(this.set)
				this.switchDialog(false)
				
				this.set = {
					title: '',
					description: ''
				}
			}
		}
	}
</script>

<style>

</style>