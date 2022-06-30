<template>
	<v-container>
				<v-row v-if="set">
			<transition name="switch" mode="out-in" appear>
					<set-info-panel :set="set">
						<template v-slot:actions>
	
							<v-btn class="ml-2 mr-2" icon="mdi-play" variant="text"></v-btn>
             
							<app-menu>
								<app-menu-item @action="doSmth" :color="'red'" :text="'Delete'" />
							</app-menu>
							
						</template>
					</set-info-panel>
					
			</transition>
			<transition name="switch_reversed" mode="out-in" appear>
					<set-chips />
					</transition>
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

<style>
.switch-enter-from,
  .switch-leave-to {
    opacity: 0;
    transform: translateY(-20px);
  }
  .switch-enter-active{
    transition: all 0.5s ease;
  }
  .switch-leave-active {
    transition: all 0.5s ease;
    position: absolute;
    width: 100%;
  }
  
.switch_reversed-enter-from,
  .switch_reversed-leave-to {
    opacity: 0;
    transform: translateY(20px);
  }
  .switch_reversed-enter-active{
    transition: all 0.5s ease;
  }
  .switch_reversed-leave-active {
    transition: all 0.5s ease;
    position: absolute;
    width: 100%;
  }
</style>