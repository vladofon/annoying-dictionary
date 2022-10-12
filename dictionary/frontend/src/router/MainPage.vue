<template>
	<v-container>
		<v-row>
			<v-col>
				<v-btn prepend-icon="mdi-login">
					<a @click="login"><span class="h3">Click on me to Register or Login!</span></a>
				</v-btn>
				
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
export default {
	methods: {
		login() {
			window.location.href = process.env.VUE_APP_BACKEND_URL + "sessions/Google/callback";
		},
	}
}
</script>