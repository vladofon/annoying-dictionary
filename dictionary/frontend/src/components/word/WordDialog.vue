<template>
	<app-dialog>
		<template v-slot:dialog-title>
			<span class="text-white">Add new item to set</span>
		</template>
		<v-text-field label="Value" variant="filled" color="teal"></v-text-field>
		<v-textarea
			rounded
			color="teal"
			class="bg-grey-lighten-3 pa-3 px-6 mt-n5"
			variant="plain"
			name="input-7-4"
			label="Context"
			placeholder="Try to describe this word or phrase in a few sentences..."
		></v-textarea>
		<template v-slot:dialog-actions>
			add item
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