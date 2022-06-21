<template>
	<v-container>
	
		<transition name="switch" mode="out-in">
			<v-row v-if="sets.length">
				<transition-group name="list" appear>
					<v-col cols="4" v-for="set in sets" :key="set.id">
						<set-card :set="set"/>
					</v-col>
				</transition-group>
			</v-row>
			<v-row v-else class="justify-center align-center">
				<v-col class="align-self-center">
					<h1 class="text-center" rounded>You have not any set!</h1>
				</v-col>
			</v-row>
		</transition>

	</v-container>
</template>

<script>
	import SetCard from '@/components/set/SetCard.vue'
	import { mapGetters } from 'vuex'
	
	export default {
		props: ['sets'],
		components: {
			SetCard
		},
		computed: {
			...mapGetters('set', ['sortedByStarsSets'])
		}
	}
</script>

<style scoped>
	.list-enter-active {
		transition: all 0.4s ease;
	}
	.list-leave-active {
		transition: all 0.4s ease;
		position: absolute;
	}
	.list-enter-from {
		opacity: 0;
		transform: scale(0.6)
	}
	.list-enter-to {
		opacity: 1;
		transform: scale(1)
	}
	.list-leave-from {
		opacity: 1;
		transform: scale(1)
	}
	.list-leave-to {
		opacity: 0;
		transform: scale(0.6)
	}
	.list-move {
		transition: all 0.3s ease;
	}
	
	
  .switch-enter-from,
  .switch-leave-to {
    opacity: 0;
    transform: translateY(20px);
  }
  .switch-enter-active{
    transition: all 0.5s ease;
  }
  .switch-leave-active {
    transition: all 0.5s ease;
    position: absolute;
    width: 100%;
  }
</style>