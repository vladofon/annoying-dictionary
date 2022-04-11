<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">Add new item to set</span>
		</template>
		<v-text-field v-model="word.value" autofocus label="Value" variant="filled" color="teal"></v-text-field>
		<v-textarea
			v-model="word.context"
			rounded
			color="teal"
			class="bg-grey-lighten-3 pa-3 px-6 mt-n5"
			variant="plain"
			name="input-7-4"
			label="Context"
			placeholder="Try to describe this word or phrase in a few sentences..."
		></v-textarea>
		<template v-slot:dialog-actions>
			<v-btn @click="createWord" color="teal" text>
				Add
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
				word: {
					value: '',
					context: ''
				}
			}
		},
		methods: {
			...mapMutations('word', ['addWord']),
			...mapMutations(['switchDialog']),
			createWord() {
				this.word.id = Math.floor(Math.random() * 100000)
				this.addWord(this.word)
				this.switchDialog(false)
				
				this.word = {
					value: '',
					context: ''
				}
			}
		}
	}
</script>

<style>

</style>