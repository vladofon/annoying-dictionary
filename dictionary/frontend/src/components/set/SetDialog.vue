<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">{{dialogMode}} set</span>
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
			<v-btn @click="setAction" color="teal" text>
				{{dialogMode}}
			</v-btn>
		</template>
	</app-dialog>
</template>

<script>
	import AppDialog from '@/components/AppDialog.vue'
	import DialogModes from '@/components/set/misc/DialogModes'
	import { mapMutations, mapState, mapActions } from 'vuex'
	
	export default {
		components: {
			AppDialog
		},
		computed: {
			set: {
				get() {
					return this.$store.state.set.operableSet
				}
			},
			...mapState('set', ['dialogMode'])
		},
		methods: {
			...mapMutations('set', ['setOperableSet']),
			...mapMutations(['switchDialog']),
			...mapActions('set', ['createSet', 'editSet']),
			
			addSet() {
				this.createSet(this.set)
				this.switchDialog(false)
				
				this.setOperableSet({id:null, title:'', description: ''})
			},
			updateSet() {
				this.editSet(this.set)
				this.switchDialog(false)
				
				this.setOperableSet({id:null, title:'', description: ''})
			},
			setAction() {
				switch(this.dialogMode) {
				case DialogModes.CREATE:
					this.addSet()
					break
				case DialogModes.EDIT:
					this.updateSet()
					break
				}
			}
		}
	}
</script>

<style>

</style>