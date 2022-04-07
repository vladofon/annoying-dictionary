<template>

	<v-container fluid class="bg-teal ">
		<v-row>
			<v-col class="d-flex">
				<h3 class="text-white" style="margin: auto 0">Your sets</h3>
				<v-spacer></v-spacer>
				<div>
					<v-btn @click="switchDialog(true)" rounded="pill" class="text-black">
						<v-icon color="black">mdi-plus</v-icon>
						Create new
					</v-btn>
				</div>
			</v-col>
		</v-row>
		
	</v-container>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
		methods: {
			...mapMutations({
				switchDialog: 'switchDialog'
			})
		}
	}
</script>

<style>

</style>