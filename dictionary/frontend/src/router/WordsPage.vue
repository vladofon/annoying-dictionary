<template>
	<word-form />
	<word-list />
</template>

<script>
	import WordForm from '@/components/word/WordForm.vue'
	import WordList from '@/components/word/WordList.vue'
	
	
	export default {
		name: 'words-page',
		components: {
			WordForm,
			WordList
		}	
	}
	
</script>

<style>

</style>