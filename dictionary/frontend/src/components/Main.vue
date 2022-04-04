<template>
	<div>
		{{ content }}
	</div>
</template>

<script>
import { HTTP } from '@/api/http'

 export default {
	 data() {
		 return {
			 content: ''
		 }
	 },
	 created() {
		 HTTP.get()
		 .then(response => {
			 console.log(response.data)
      	this.content = response.data
    })
	 }
 }
</script>

<style>

</style>