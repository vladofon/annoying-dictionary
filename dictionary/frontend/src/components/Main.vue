<template>
	<div>
	
		<div v-for="word in content">
			<div>{{ word.value }}</div>
			<div>{{ word.context }}</div>
			<button @click="editWord">Edit</button>
			<button @click="deleteWord">Delete</button>
			<hr>
		</div>
		
	</div>
</template>

<script>
import wordApi from '@/api/word'

 export default {
	 data() {
		 return {
			 content: []
		 }
	 },
	 methods: {
		 
	 },
	 async created() {
		 const response = await wordApi.list()
		 this.content = response.data
	 }
 }
</script>

<style>

</style>