<template>
	<v-container class="my-3">
		<v-card class="mx-auto" max-width="634" tile>
			<v-img cover src="https://picsum.photos/1920/1080?random" gradient="to top right, rgba(19,84,122,.8), rgba(128,208,199,.8)" class="pa-3">
				<v-row>
					<v-col cols="5">
						
							<v-avatar color="grey" size="150" rounded="10" >
								<v-img :src="profile.avatar" height="100%" cover></v-img>
							</v-avatar>
							<v-list-item class="text-white" :title="profile.name" subtitle="Free account">
							
							</v-list-item>
	
					</v-col>
					<v-col cols="7">
					
						<v-container>
							<v-row>
								<v-col cols="6">
									<v-card class="text-center pa-3">
										<h4 class="text-center pa-1 bg-teal">
											<span class="text-white">Sets</span>
										</h4>
										<v-divider></v-divider>
										<div class="pa-3 pt-4">
											<b>15</b>
										</div>
									</v-card>
								</v-col>
								
								<v-col cols="6">
									<v-card class="text-center pa-3">
										<h4 class="text-center pa-1 bg-teal">
											<span class="text-white">Words</span>
										</h4>
										<v-divider></v-divider>
										<div class="pa-3 pt-4">
											<b>360</b>
										</div>
									</v-card>
								</v-col>
								
								<v-col cols="6">
									<v-card class="text-center pa-3">
										<h4 class="text-center pa-1 bg-teal">
											<span class="text-white">Featured</span>
										</h4>
										<v-divider></v-divider>
										<div class="pa-3 pt-4">
											<b>10</b>
										</div>
									</v-card>
								</v-col>
								
								<v-col cols="6">
									<v-card class="text-center pa-3">
										<h4 class="text-center pa-1 bg-teal">
											<span class="text-white">Stars</span>
										</h4>
										<v-divider></v-divider>
										<div class="pa-3 pt-4">
											<b>245</b>
										</div>
									</v-card>
								</v-col>
								
							</v-row>
						</v-container>
							
					</v-col>
				</v-row>
			</v-img>
		</v-card>
	</v-container>
</template>

<script>
	import { mapState } from 'vuex'
	
	export default {
		computed: {
			...mapState('profile', ['profile'])
		}
	}
</script>














