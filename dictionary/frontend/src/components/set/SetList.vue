<template>
	<v-container>
		<v-row>
			<v-col cols="4" v-for="item in 15" :key="item">
				<set-card/>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
	import SetCard from '@/components/set/SetCard.vue'
	
	export default {
		components: {
			SetCard
		}
	}
</script>