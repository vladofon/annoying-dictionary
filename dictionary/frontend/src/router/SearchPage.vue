<template>
	<app-header>Found words</app-header>
	<word-list :words="words"/>
	<app-header>Found sets</app-header>
	<set-list :sets="sets"/>
</template>

<script>
import WordList from '@/components/word/WordList.vue'
import SetList from '@/components/set/SetList.vue'
import AppHeader from '@/components/AppHeader.vue'
import { mapGetters, mapActions } from 'vuex'

export default {
	components: {
		AppHeader,
		WordList,
		SetList,
	},
	computed: {
		...mapGetters('word', ['words']),
		...mapGetters('set', ['sets']),
	},
	methods: {
		...mapActions('word', ['fetchWordsSample']),
		...mapActions('set', ['fetchSetsSample']),
	},
	created(){
		this.fetchWordsSample(this.$route.params.value)
		this.fetchSetsSample(this.$route.params.value)
	}
}
</script>