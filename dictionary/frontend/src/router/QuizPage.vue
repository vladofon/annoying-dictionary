<template>
	<quiz-header />
	<quiz-list v-if="operableSet.words" :items="operableSet.words"/> 
</template>

<script>
	import QuizList from '@/components/quiz/QuizList.vue'
	import QuizHeader from '@/components/quiz/QuizHeader.vue'
	import { mapGetters, mapActions } from 'vuex'
	
	export default {
		components: {
			QuizList,
			QuizHeader
		},
		computed: {
			...mapGetters('set', ['operableSet'])
		},
		methods: {
			...mapActions('set', ['fetchSet'])
		},
		created() {
			this.fetchSet(this.$route.params.id)
		}
	}
</script>