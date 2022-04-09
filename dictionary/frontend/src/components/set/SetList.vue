<template>
	<v-container>
		<v-row>
			<v-col cols="4" v-for="set in sets" :key="set.id">
				<set-card :set="set"/>
			</v-col>
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