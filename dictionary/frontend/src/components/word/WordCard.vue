<template>
	<v-card class="mt-5 pa-4"
		elevation="5">
		
    <v-row>
			<v-col>
				<v-card-title>
					{{word.value}}
					<v-btn flat class="ml-1" icon="mdi-volume-high"></v-btn>
					<v-spacer></v-spacer>
					
					<app-menu v-if="isUserWord">
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
	import { mapMutations, mapActions, mapGetters } from 'vuex'
	import DialogModes from '@/components/word/misc/DialogModes'
	import AppMenu from '@/components/AppMenu.vue'
	import AppMenuItem from '@/components/AppMenuItem.vue'
	
	export default {
		components: {
			AppMenu,
			AppMenuItem
		},
		props: ['word'],
		computed: {
			...mapGetters('set', ['operableSet']),
			...mapGetters('set', ['set']),
			...mapGetters('profile', ['profile']),
		},
		methods: {
			...mapMutations('word', ['setDialogMode', 'setOperableWord']),
			...mapActions('word', ['deleteWord']),
			...mapMutations(['switchDialog']),
			
			editWord() {
				this.setDialogMode(DialogModes.EDIT)
				this.setOperableWord({id:this.word.id, setId: this.operableSet.id, value:this.word.value, context:this.word.context})
				this.switchDialog(true)
			},
			
			isUserWord() {
				if(this.set(this.word.setId).author.id === this.profile.id) {
					return true
				}
				
				return false
			}
		}
	}
</script>

<style>

</style>