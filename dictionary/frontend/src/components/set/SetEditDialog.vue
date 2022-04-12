<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">Edit set</span>
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
			<v-btn @click="updateSet" color="teal" text>
				Edit
			</v-btn>
		</template>
	</app-dialog>
</template>

<script>
	import AppDialog from '@/components/AppDialog.vue'
	import { mapMutations, mapState } from 'vuex'
	
	export default {
		components: {
			AppDialog
		},
		data() {
			return {
				set: {
					id: null,
					title: '',
					description: ''
				}
			}
		},
		computed: {
			...mapState('set', ['editableSetIndex'])
		},
		methods: {
			...mapMutations('set', ['editSet']),
			...mapMutations(['switchDialog']),
			updateSet() {
				this.set.id = this.editableSetIndex
				this.editSet(this.set)
				this.switchDialog(false)
				
				this.set = {
					id: null,
					title: '',
					description: ''
				}
			}
		}
	}
</script>