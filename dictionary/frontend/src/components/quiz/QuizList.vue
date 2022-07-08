<template>
	<v-container class="d-flex align-center justify-center flex-column"  style="height: 80vh" fill-height>
		
			<quiz-card :quiz-item="item" :total-count="items.length"></quiz-card>

		<!-- <div><v-btn @click="showP = !showP" class="mt-3" >Show card</v-btn></div> -->
	</v-container>
</template>

<script>
	import QuizCard from '@/components/quiz/QuizCard.vue'
	import { mapState, mapMutations } from 'vuex'
	
	export default {
		props: ['items'],
		data() {
			return {
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

