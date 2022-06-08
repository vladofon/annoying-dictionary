<template>
  <v-card
    class="ma-3"
    width="344"
    outlined
  >
    <v-list-item three-line class="justify-space-between">
      <div>
        <div class="text-overline mb-4 d-flex align-content-center">
          <span class="align-self-center">PUBLIC SET</span>
        </div>
        <v-list-item-title class="text-h5 mb-1">
          {{set.title}}
        </v-list-item-title>
        <v-list-item-subtitle>{{set.description}}</v-list-item-subtitle>
      </div>

      <v-list-item-avatar
        tile
        size="80"
        color="grey"
      ></v-list-item-avatar>
      
      <v-spacer></v-spacer>
      
      
			<v-menu v-model="menu" transition="scale-transition" :close-on-content-click="true">
				<template v-slot:activator="{ props }">
					<v-btn v-bind="props" flat icon="mdi-dots-vertical" class="align-self-start"></v-btn>
				</template>
				
				<v-list elevation="5" rounded class="pa-0" @click="menu = false">
				
					<v-list-item>
						<v-list-item-title>
							<v-btn @click="removeSet(set.id)" class="text-red" plain>Delete</v-btn>
						</v-list-item-title>
					</v-list-item>
					
					<v-list-item>
						<v-list-item-title>
							<v-btn @click="editSet" class="text-orange" plain>Edit</v-btn>
						</v-list-item-title>
					</v-list-item>
					
					<v-list-item>
						<v-list-item-title>
							<v-btn class="text-orange" plain>Private</v-btn>
						</v-list-item-title>
					</v-list-item>
					
				</v-list>
			</v-menu>
      
    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text
        color="teal"
      >
        Show
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
	import { mapState, mapMutations } from 'vuex'
	import DialogModes from '@/components/set/misc/DialogModes'
	
	export default {
		props: ['set'],
		computed: {
			...mapState('set', ['sets'])
		},
		data() {
			return {
				menu: false
			}
		},
		methods: {
			...mapMutations('set', ['removeSet', 'setOperableSet', 'setDialogMode']),
			...mapMutations(['switchDialog']),
			
			editSet() {
				this.setDialogMode(DialogModes.EDIT)
				
				this.setOperableSet({
					id:this.set.id, 
					title:this.set.title, 
					description:this.set.description
				})
				
				this.switchDialog(true)
			}
		}
	}
</script>

<style>

</style>