<template>
	<v-container>
		<v-row>
			<v-col cols="12" class="mt-10">
          <v-card
            color="#952175"
            theme="dark"
          >
            <div class="d-flex flex-no-wrap justify-space-between">
              <div>
                <v-card-title class="text-h5">
                  Headline 1
                </v-card-title>

                <v-card-subtitle>
									Greyhound divisely hello coldly fonwderfully
                </v-card-subtitle>

                <v-card-actions>
                  <v-btn
                    class="ml-2 mr-2"
                    icon="mdi-play"
                    variant="text"
                  ></v-btn>
                  <v-btn
                    class="ml-2 mr-2"
                    icon="mdi-dots-vertical"
                    variant="text"
                  ></v-btn>
                </v-card-actions>
              </div>

							<div class="row">
							<div class="col">
              <v-avatar
                class="ma-3"
                size="125"
                rounded="0"
              >
                <v-img src="https://cdn.vuetifyjs.com/images/cards/halcyon.png"></v-img>
              </v-avatar>

              </div></div>
            </div>
          </v-card>
        </v-col>
        
        <v-col cols="12" class="text-center">
					<v-chip
					class="ma-2"
					color="green"
					text-color="white"
					prepend-
					>
						<template v-slot:prepend>
							<v-avatar
								class="green-darken-6"
							>
								360
							</v-avatar>
						</template>
					Words
					</v-chip>
					<v-chip
					class="ma-2"
					color="green"
					text-color="white"
					append-icon="mdi-playlist-check"
					prepend-
					>
						<template v-slot:prepend>
							<v-avatar
								class="green-darken-6"
							>
								15
							</v-avatar>
						</template>
					Subscribtions
					</v-chip>
					<v-chip
      class="ma-2"
      color="orange"
      text-color="white"
      append-icon="mdi-star"
    >
      Top-10
    </v-chip>
				</v-col>
		</v-row>
	</v-container>
</template>