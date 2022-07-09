<template>
	<div v-if="operableSet">
		<word-form/>
		<set-header :set="operableSet"/>
		<word-list :words="words"/>
		<word-dialog/>
	</div>
	<quiz-end-dialog v-if="$route.query.quiz && operableSet"/>
</template>

<script>
	import SetHeader from '@/components/set/SetHeader.vue'
	import WordList from '@/components/word/WordList.vue'
	import WordForm from '@/components/word/WordForm.vue'
	import WordDialog from '@/components/word/WordDialog.vue'
	import QuizEndDialog from '@/components/quiz/QuizEndDialog.vue'
	
	import { mapMutations, mapGetters, mapActions } from 'vuex'
	
	export default {
		components: {
			SetHeader,
			WordList,
			WordForm,
			WordDialog,
			QuizEndDialog
		},
		computed: {
			...mapGetters('set', ['operableSet']),
			...mapGetters('word', ['words']),
		},
		methods: {
			...mapActions('set', ['fetchSet']),
			...mapMutations('set', ['setOperableSet']),
			...mapMutations('word', ['setWords']),
			
		},
		created() {
			this.fetchSet(this.$route.params.id)
		},
		watch: {
			operableSet(loaded) {
				this.setWords(loaded.words)
			}
		}
	}
</script>