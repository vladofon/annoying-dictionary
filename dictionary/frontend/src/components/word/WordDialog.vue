<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">{{dialogMode}} item</span>
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
			<v-btn @click="wordAction" color="teal" text>
				{{dialogMode}}
			</v-btn>
		</template>
	</app-dialog>
</template>

<script>
	import AppDialog from '@/components/AppDialog.vue'
	import DialogModes from '@/components/word/misc/DialogModes'
	import { mapMutations, mapState, mapActions } from 'vuex'
	
	export default {
		components: {
			AppDialog
		},
		computed: {
			...mapState('word', ['dialogMode', 'operableWord']),
			word: {
				get() {
					return this.$store.state.word.operableWord
				}
			}
		},
		methods: {
			...mapMutations('word', ['setOperableWord']),
			...mapMutations(['switchDialog']),
			...mapActions('word', ['editWord', 'createWord']),
			
			addWord() {
				this.word.id = Math.floor(Math.random() * 100000)
				this.createWord(this.word)
				this.switchDialog(false)
				
				const word = {
					id: 0,
					value: '',
					context: ''
				}
				
				this.setOperableWord(word)
			},
			updateWord() {
				this.editWord(this.word)
				this.switchDialog(false)
				
				const word = {
					id: 0,
					value: '',
					context: ''
				}
				
				this.setOperableWord(word)
			},
			wordAction() {
				switch(this.dialogMode)
				{
					case DialogModes.CREATE:
						this.addWord()
						break
					case DialogModes.EDIT:
						this.updateWord()
						break
				}
			}
		}
	}
</script>

<style>

</style>