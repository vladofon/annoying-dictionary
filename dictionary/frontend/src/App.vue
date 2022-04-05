<template>
	<v-app class="d-flex"> 
		<app-bar /> 
		<v-main> 

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
