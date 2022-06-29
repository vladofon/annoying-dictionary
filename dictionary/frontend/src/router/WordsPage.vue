<template>
	<word-form />
	<word-dialog />
	<word-list :words="words"/>
</template>

<script>
	import WordForm from '@/components/word/WordForm.vue'
	import WordList from '@/components/word/WordList.vue'
	import WordDialog from '@/components/word/WordDialog.vue'
	import { mapActions, mapGetters } from 'vuex'
	
	export default {
		name: 'words-page',
		components: {
			WordForm,
			WordList,
			WordDialog
		},
		methods: {
			...mapActions({
				fetchWords: 'word/fetchWords',
			}),
		},
		computed: {
			...mapGetters({
				words: 'word/words'
			})
		},
		mounted() {
			this.fetchWords()
		}
	}
	
</script>

<style>

</style>