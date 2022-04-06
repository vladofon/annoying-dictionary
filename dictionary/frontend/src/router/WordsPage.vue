<template>
	<word-form />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
	<word-card />
</template>

<script>
	import WordForm from '@/components/word/WordForm.vue'
	import WordCard from '@/components/word/WordCard.vue'
	
	export default {
		name: 'words-page',
		components: {
			WordForm,
			WordCard
		}	
	}
	
</script>

<style>

</style>