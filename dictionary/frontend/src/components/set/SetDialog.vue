<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">Create new set</span>
		</template>
		<v-text-field autofocus label="Name" variant="filled" color="teal"></v-text-field>
		<v-textarea
			rounded
			color="teal"
			class="bg-grey-lighten-3 pa-3 px-6 mt-n5"
			variant="plain"
			name="input-7-4"
			label="Description"
			placeholder="Enter some description..."
		></v-textarea>
		<template v-slot:dialog-actions>
			create
		</template>
	</app-dialog>
</template>

<script>
	import AppDialog from '@/components/AppDialog.vue'
	
	export default {
		components: {
			AppDialog
		}
	}
</script>

<style>

</style>