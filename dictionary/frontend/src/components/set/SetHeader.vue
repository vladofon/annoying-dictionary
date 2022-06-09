<template>
	<v-container>
		<v-row>

				<set-info-panel :set="set">
					<template v-slot:actions>

						<v-btn class="ml-2 mr-2" icon="mdi-play" variant="text"></v-btn>
                  
						<app-menu>
							<app-menu-item @action="doSmth" :color="'red'" :text="'Delete'" />
						</app-menu>
						
					</template>
        </set-info-panel>
        
        <set-chips />
        
		</v-row>
	</v-container>
</template>

<script>
	import AppMenu from '@/components/AppMenu.vue'
	import AppMenuItem from '@/components/AppMenuItem.vue'
	import SetInfoPanel from '@/components/set/SetInfoPanel.vue'
	import SetChips from '@/components/set/SetChips.vue'
	
	export default {
		components: {
			AppMenu,
			AppMenuItem,
			SetInfoPanel,
			SetChips
		},
		props: ['set'],
		methods: {
			doSmth() {
				
			}
		}
	}
</script>