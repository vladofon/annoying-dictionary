<template>
	<quiz-header />
	<quiz-list /> 
</template>

<script>
	import QuizList from '@/components/quiz/QuizList.vue'
	import QuizHeader from '@/components/quiz/QuizHeader.vue'
	
	
	export default {
		components: {
			QuizList,
			QuizHeader
		}
	}
</script>