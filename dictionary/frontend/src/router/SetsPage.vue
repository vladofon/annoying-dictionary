<template>
	<set-form />
	<set-dialog />
	<set-list />
</template>

<script>
	import SetList from '@/components/set/SetList.vue'
	import SetForm from '@/components/set/SetForm.vue'
	import SetDialog from '@/components/set/SetDialog.vue'
	
	export default {
		components: {
			SetList,
			SetForm,
			SetDialog
		}
	}
</script>