<template>
	<word-form/>
	<set-header/>
	<word-list/>
	<word-dialog/>
</template>

<script>
	import SetHeader from '@/components/set/SetHeader.vue'
	import WordList from '@/components/word/WordList.vue'
	import WordForm from '@/components/word/WordForm.vue'
	import WordDialog from '@/components/word/WordDialog.vue'
	
	export default {
		components: {
			SetHeader,
			WordList,
			WordForm,
			WordDialog
		}
	}
</script>