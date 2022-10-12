<template>
	<v-container>
		<v-row>
			<v-col>
				<a @click="login"><h3>Register or login now!</h3></a>
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