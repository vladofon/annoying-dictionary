<template>
	<word-list :words="words"/>
</template>

<script>
	import WordList from '@/components/word/WordList.vue'
	import { mapActions, mapGetters } from 'vuex'
	
	export default {
		components: {
			WordList
		},
		computed: {
			...mapGetters('word', ['words'])
		},
		methods: {
			...mapActions('word', ['fetchByValue'])
		},
		created() {
			console.log(this.$route.params.value)
			this.fetchByValue(this.$route.params.value)
		}
	}
</script>