<template>
<transition name="bounce">
	<v-card v-if="showP" elevation="5" width="350" class="d-flex flex-column">
		<v-card-subtitle>
			<v-container class="mt-3">
				<v-row>
					<v-col  class="pa-0">
						<v-chip class="mr-2" :class="bgColor">{{currentIndex + 1}} / {{totalCount}}</v-chip> Words passed
					</v-col>
				</v-row>
			</v-container>
		</v-card-subtitle>
	
		<v-card-text class="full-height">
			<v-container class="pb-0">
				<v-row>
					<v-col  class="pa-0">
						{{quizItem.context}}
					</v-col>
				</v-row>
			</v-container>
		</v-card-text>

		<v-card-actions>
			<v-container>
			<v-row>
				<v-col cols="12" :class="bgColor">
					<v-text-field @keyup.enter="incrementCurrentIndex"
						v-model="userInput"
						class="mb-n5"
						autofocus
						label="Word" 
						variant="plain" 
						:color="fieldColor" 
						background-color="#565656"
						placeholder="Enter the word...">
					</v-text-field>
				</v-col>
			
				<v-col cols="12" class="pa-0 pt-3">
					<v-divider></v-divider>
				</v-col>
				
				<v-col cols="12" class="pb-0">
					<div class="d-inline-block mx-10">
						<v-btn @click="validate" :color="(confirmButton) ? 'teal' : disabledColor" :disabled="!confirmButton" :flat="!confirmButton">
							Confirm
						</v-btn>
						<v-btn :color="(rejectButton) ? 'red' : disabledColor" :disabled="!rejectButton" :flat="!rejectButton">
							I don't know
						</v-btn>
					</div>

				</v-col>
			</v-row>
			</v-container>
		</v-card-actions>
	</v-card>
</transition>
</template>

<script>
	import { mapState, mapMutations } from 'vuex'
	
	export default {
		props: ['quizItem', 'totalCount'],
		data() {
			return {
				showP: true,
				fieldColor: 'teal',
				bgColor: '',
				disabledColor: 'bg-gray',
				confirmButton: true,
				rejectButton: true,
				userInput: '',
			}
		},
		methods: {
			...mapMutations({
				incrementCurrentIndex: 'quiz/incrementCurrentIndex'
			}),
			validate() {
				if(this.userInput !== this.quizItem.header) {
					this.fieldColor = 'red'
					this.bgColor = 'bg-red-lighten-4'
					this.confirmButton = false
					this.rejectButton = false
				} else {
					this.fieldColor = 'teal'
					this.bgColor = 'bg-teal-lighten-4'
					this.confirmButton = false
					this.rejectButton = false
				}
				
				setTimeout(() => {this.nextCard()}, 2000)
			},
			nextCard() {
				this.showP = false
				this.fieldColor = 'teal'
				this.bgColor = 'bg-grey-lighten-3'
				this.confirmButton = true
				this.rejectButton = true
				this.userInput = ''
				this.incrementCurrentIndex()
				setTimeout(() => {this.showP = true}, 400)
			}
		},
		computed: {
			...mapState('quiz', ['currentIndex'])
		},
		watch: {
			currentIndex(value) {
				if(value === this.totalCount) {
					this.$router.push('/sets/' + this.$route.params.id)
				}
			}
		}
	}
</script>

<style scoped>
	.full-height {
		min-height: 200px;
	}
	.v-field__field {
		background: grey;
	}
	
	.bounce-enter-active {
		animation: bounce-in 0.5s;
	}
	.bounce-leave-active {
		animation: bounce-in 0.5s reverse;
	}
	@keyframes bounce-in {
		0% {
			transform: scale(0);
		}
		50% {
			transform: scale(1.25);
		}
		100% {
			transform: scale(1);
		}
	}
</style>