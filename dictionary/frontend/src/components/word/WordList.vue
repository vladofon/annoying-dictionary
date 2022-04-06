<template>
	<v-container class="pa-10">
		<v-row>
			<v-col>
				<div v-for="word in 10" :key="word">
					<word-card />
				</div>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
	import WordCard from '@/components/word/WordCard.vue'
	
	export default {
		components: {
			WordCard
		}	
	}
</script>

<style>

</style>