<template>

	<v-container fluid class="bg-teal ">
		<v-row>
			<v-col class="d-flex">
				<h3 class="text-white" style="margin: auto 0">Profile</h3>
				<v-spacer></v-spacer>
				<div>
					<v-btn @click="editProfile" rounded="pill" class="text-black">
						<v-icon color="black">mdi-plus</v-icon>
						Change info
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
			}),
			...mapMutations('profile', ['loadLocalProfile']),
			
			editProfile() {
				this.loadLocalProfile()
				this.switchDialog(true)
			}
		}
	}
</script>