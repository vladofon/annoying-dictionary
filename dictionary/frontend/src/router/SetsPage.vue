<template>
	<set-form />
	<set-dialog />
	<set-list :sets="sets"/>
</template>

<script>
	import SetList from '@/components/set/SetList.vue'
	import SetForm from '@/components/set/SetForm.vue'
	import SetDialog from '@/components/set/SetDialog.vue' 
	import { mapState } from 'vuex'
	
	export default {
		components: {
			SetList,
			SetForm,
			SetDialog
		},
		methods: {
			...mapState('set', ['sets'])
		}
	}
</script>