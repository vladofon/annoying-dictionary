<template>
	<v-app> 
		<app-bar /> 
		<v-main> 
			<router-view>
			
			</router-view>
		</v-main> 
		<app-footer />
	</v-app>
</template>

<script>
import AppBar from '@/components/AppBar.vue'
import AppFooter from '@/components/AppFooter.vue'

export default {
  name: 'App',
  components: {
		AppBar,
		AppFooter,
  },
}
</script>
