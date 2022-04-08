<template>
	<v-card elevation="5" width="350" class="d-flex flex-column" style="margin: 0 auto">
		<v-card-subtitle>
			<v-container class="mt-3">
				<v-row>
					<v-col  class="pa-0">
						<v-chip class="mr-2">{{currentIndex + 1}} / {{totalCount}}</v-chip> Words passed
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
				<v-col cols="12" class="bg-grey-lighten-3">
					<v-text-field @keyup.enter="incrementCurrentIndex"
						class="mb-n5"
						autofocus
						label="Word" 
						variant="plain" 
						color="teal" 
						background-color="#565656"
						placeholder="Enter the word...">
					</v-text-field>
				</v-col>
			
				<v-col cols="12" class="pa-0 pt-3">
					<v-divider></v-divider>
				</v-col>
				
				<v-col cols="12" class="pb-0">
					<div class="d-inline-block mx-10">
						<v-btn @click="incrementCurrentIndex" color="teal">
							Confirm
						</v-btn>
						<v-btn color="red">
							I don't know
						</v-btn>
					</div>

				</v-col>
			</v-row>
			</v-container>
		</v-card-actions>
	</v-card>
</template>

<script>
	import { mapState, mapMutations } from 'vuex'
	
	export default {
		props: ['quizItem', 'totalCount'],
		methods: {
			...mapMutations({
				incrementCurrentIndex: 'quiz/incrementCurrentIndex'
			}),
		},
		computed: {
			...mapState('quiz', ['currentIndex'])
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
</style>