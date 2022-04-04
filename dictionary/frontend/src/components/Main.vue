<template>
	<div>
		{{ content }}
	</div>
</template>

<script>
import axios from 'axios'

 export default {
	 data() {
		 return {
			 content: ''
		 }
	 },
	 created() {
		 axios.get(`http://localhost:8080/`)
		 .then(response => {
			 console.log(response.data)
      	this.content = response.data
    })
	 }
 }
</script>

<style>

</style>