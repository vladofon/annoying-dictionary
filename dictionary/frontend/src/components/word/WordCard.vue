<template>
	<v-card class="mt-5 pa-4"
		elevation="5">
		
    <v-row>
			<v-col>
				<v-card-title>
					{{word.value}}
					<v-btn flat class="ml-1" icon="mdi-volume-high"></v-btn>
					<v-spacer></v-spacer>
					
					<app-menu>
						<app-menu-item @action="deleteWord(word.id)" :color="'red'" :text="'Delete'" />
						<app-menu-item @action="editWord" :color="'orange'" :text="'Edit'" />
					</app-menu>
					
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
	import { mapMutations, mapActions } from 'vuex'
	import DialogModes from '@/components/word/misc/DialogModes'
	import AppMenu from '@/components/AppMenu.vue'
	import AppMenuItem from '@/components/AppMenuItem.vue'
	
	export default {
		components: {
			AppMenu,
			AppMenuItem
		},
		props: ['word'],
		methods: {
			...mapMutations('word', ['setDialogMode', 'setOperableWord']),
			...mapActions('word', ['deleteWord']),
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