<template>
	<v-card color="#1F7087" theme="dark" class="ma-1">
		<div class="d-flex flex-no-wrap justify-space-between">
		
			<div>
				<v-card-title class="text-h5">
					{{profileData.name}}
				</v-card-title>
				
				<v-card-subtitle><v-icon class="mr-1">mdi-heart</v-icon>{{profileData.likes}} likes</v-card-subtitle>
				
				<v-card-actions>
					<v-btn class="ml-2" variant="outlined" size="small">
						profile
					</v-btn>
				</v-card-actions>
			</div>
		
			<v-avatar class="ma-3" size="125" rounded="0">
				<v-img :src="profileData.userpic"></v-img>
			</v-avatar>
			
		</div>
		
		<v-card-actions>
				<v-expansion-panels v-model="panel" variant="inset" class="my-4">
					<v-expansion-panel
						class="ma-1"
						v-for="i in 3"
						:key="i"
						title="User set with words"
					>
						<v-expansion-panel-text>
							text="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
							<br/>
							<v-btn variant="outlined" class="mt-3">Show</v-btn>
						</v-expansion-panel-text>
					</v-expansion-panel>
				</v-expansion-panels>
				
			</v-card-actions>
			
			<v-container>
				<v-row>
					<v-col>
						<v-btn>Show more</v-btn>
					</v-col>
					<v-col class="pa-4">
						<v-icon>mdi-view-dashboard</v-icon>
						{{profileData.sets}} sets
					</v-col>
				</v-row>
			</v-container>
			
	</v-card>
</template>

<script>
export default {
	data() {
		return {
			profileData: {
				name: 'Something wrong',
				userpic: 'https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F13%2F2015%2F04%2F05%2Ffeatured.jpg&q=60',
				likes: 2387,
				sets: 10,
			},
			panel: [1 ,1 , 1],
		}
	}
}
</script>