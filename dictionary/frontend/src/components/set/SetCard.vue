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
      
			<app-menu>
				<app-menu-item @action="deleteSet(set.id)" :color="'red'" :text="'Delete'"/>
				<app-menu-item @action="editSet" :color="'orange'" :text="'Edit'"/>
			</app-menu>
      
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
      <v-spacer></v-spacer>
			<v-chip v-if="set.stars"
				class="ma-2"
				color="orange"
				text-color="white"
				append-icon="mdi-star"
			>
			{{set.stars}}
			</v-chip>
			<v-chip v-else
				class="ma-2"
				color="gray"
				text-color="white"
				append-icon="mdi-star"
			>
			-
			</v-chip>
    </v-card-actions>
  </v-card>
</template>

<script>
	import { mapState, mapMutations, mapActions } from 'vuex'
	import DialogModes from '@/components/set/misc/DialogModes'
	import AppMenu from '@/components/AppMenu.vue'
	import AppMenuItem from '@/components/AppMenuItem.vue'
	
	export default {
		components: {
			AppMenu,
			AppMenuItem
		},
		props: ['set'],
		computed: {
			...mapState('set', ['sets'])
		},
		methods: {
			...mapMutations('set', ['setOperableSet', 'setDialogMode']),
			...mapMutations(['switchDialog']),
			...mapActions('set', ['deleteSet']),
			
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