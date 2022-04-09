<template>
	<v-container>
		<v-row>
			<transition-group name="list" appear>
				<v-col cols="4" v-for="set in sets" :key="set.id">
					<set-card :set="set"/>
				</v-col>
			</transition-group>
		</v-row>
	</v-container>
</template>

<script>
	import SetCard from '@/components/set/SetCard.vue'
	import { mapState } from 'vuex'
	
	export default {
		components: {
			SetCard
		},
		computed: {
			...mapState('set', ['sets'])
		}
	}
</script>

<style>
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
</style>