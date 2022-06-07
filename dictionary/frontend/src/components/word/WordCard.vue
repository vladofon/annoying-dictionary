<template>
	<v-card class="mt-5 pa-4"
		elevation="5">
		
    <v-row>
			<v-col>
				<v-card-title>
					{{word.value}}
					<v-btn flat class="ml-1" icon="mdi-volume-high"></v-btn>
					<v-spacer></v-spacer>
					
					<v-menu transition="scale-transition">
						<template v-slot:activator="{ props }">
							<v-btn v-bind="props" flat icon="mdi-dots-vertical" class="align-self-start"></v-btn>
						</template>
						
						<v-list elevation="5" rounded class="pa-0">
						
							<v-list-item>
								<v-list-item-title>
									<v-btn @click="removeWord(word.id)" class="text-red" plain>Delete</v-btn>
								</v-list-item-title>
							</v-list-item>
							<v-list-item>
								<v-list-item-title>
									<v-btn @click="editWord" class="text-orange" plain>Edit</v-btn>
								</v-list-item-title>
							</v-list-item>

						</v-list>
					</v-menu>
					
				</v-card-title>
				<v-card-subtitle>
					[{{word.id}}] Subtitle
				</v-card-subtitle>
				<v-card-text>
					{{word.context}}
				</v-card-text>
			</v-col>
    </v-row>
    


	</v-card>
</template>

<script>
	import { mapMutations } from 'vuex'
	import DialogModes from '@/components/word/misc/DialogModes'
	
	export default {
		props: ['word'],
		methods: {
			...mapMutations('word', ['removeWord', 'updateWord', 'setDialogMode', 'setOperableWord']),
			...mapMutations(['switchDialog']),
			
			editWord() {
				this.setDialogMode(DialogModes.EDIT)
				this.setOperableWord({id:this.word.id, value:this.word.value, context:this.word.context})
				this.switchDialog(true)
			}
		}
	}
</script>

<style>

</style>