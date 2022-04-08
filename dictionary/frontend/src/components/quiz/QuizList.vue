<template>
	<v-container>
		<quiz-card :quiz-item="item" :total-count="items.length">
		</quiz-card>
	</v-container>
</template>

<script>
	import QuizCard from '@/components/quiz/QuizCard.vue'
	import { mapState, mapMutations } from 'vuex'
	
	export default {
		data() {
			return {
				items: [
					{header: 'hrader-1', context: 'content-1'},
					{header: 'hrader-2', context: 'content-2'},
					{header: 'hrader-3', context: 'content-3'},
					{header: 'hrader-4', context: 'content-4'},
					{header: 'hrader-5', context: 'content-5'},
				],
				item: {
					header: '',
					context: '',
				},
			}
		},
		components: {
			QuizCard
		},
		methods: {
			...mapMutations({
				setCurrentIndex: 'quiz/setCurrentIndex'
			}),
			
			nextCard() {
				
			}
		},
		computed: {
			...mapState('quiz', ['currentIndex'])
		},
		watch: {
			currentIndex() {
				this.item = this.items[this.currentIndex]
			}
		},
		created() {
			this.item = this.items[this.currentIndex]
		}
	}

</script>