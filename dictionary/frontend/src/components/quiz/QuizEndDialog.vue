<template>
  <v-row justify="space-around">
    <v-col cols="auto">
      <v-dialog
        transition="dialog-top-transition"
        v-model="isOpen"
      >
        <template v-slot:default="{ isActive }">
          <v-card>
            <v-toolbar
              color="teal"
            ><span class="text-white text-h6">Quiz results</span></v-toolbar>
            <v-card-text>
							<div v-if="$route.query.errors === '0'">
								<div class="text-h2 pa-12">Excellent work!</div>
																<v-progress-linear class="my-5"
									:color="color"
									height="25"
									v-model="correct"
								>
									<template v-slot:default="{ value }">
										<strong class="text-white">{{value}}% You have not any errors</strong>
									</template>
								</v-progress-linear>
							</div>
              <div v-else>
								<div class="text-h2 pa-14 text-no-wrap">Need diapers?</div>
								<v-progress-linear class="my-5"
									:color="color"
									height="25"
									v-model="correct"
								>
									<template v-slot:default="{ value }">
										<strong>{{ Math.ceil(value) }}% correct answers</strong>
									</template>
								</v-progress-linear>
              </div>
            </v-card-text>
            <v-divider/>
            <v-card-actions class="justify-end">
            
              <v-btn
                text
                color="orange"
                @click="$router.push(`/quiz/${$route.params.id}`)"
              >Try again</v-btn>
              <v-btn
                text
                
                @click="isActive.value = false"
              >Close</v-btn>
            </v-card-actions>
          </v-card>
        </template>
      </v-dialog>
    </v-col>
  </v-row>
</template>

<script>
export default {
	data() {
		return {
			isOpen: true,
			correct: 100 - (parseInt(this.$route.query.errors) / parseInt(this.$route.query.count) * 100),
			colors: [
				{value: 0, result: 'black'},
				{value: 10, result: 'red'},
				{value: 20, result: 'deep-orange'},
				{value: 30, result: 'orange'},
				{value: 40, result: 'amber'},
				{value: 50, result: 'yellow'},
				{value: 60, result: 'lime'},
				{value: 70, result: 'light-green'},
				{value: 80, result: 'green'},
				{value: 90, result: 'teal'},
				{value: 100, result: 'indigo'},
			]
		}
	},
	computed: {
		color() {
			return this.colors.filter(clr => clr.value === Math.ceil(this.correct / 10) * 10)[0].result
		}
	}
}
</script>