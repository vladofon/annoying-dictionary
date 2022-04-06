<template>
	<word-form />
	<word-dialog />
	<word-list />
</template>

<script>
	import WordForm from '@/components/word/WordForm.vue'
	import WordList from '@/components/word/WordList.vue'
	import WordDialog from '@/components/word/WordDialog.vue'
	
	
	export default {
		name: 'words-page',
		components: {
			WordForm,
			WordList,
			WordDialog
		}	
	}
	
</script>

<style>

</style>