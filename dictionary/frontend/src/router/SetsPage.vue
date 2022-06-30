<template>
	<set-form />
	<set-dialog />
	<set-list :sets="sets"/>
</template>

<script>
	import SetList from '@/components/set/SetList.vue'
	import SetForm from '@/components/set/SetForm.vue'
	import SetDialog from '@/components/set/SetDialog.vue' 
	import { mapGetters, mapActions } from 'vuex'
	
	export default {
		components: {
			SetList,
			SetForm,
			SetDialog
		},
		computed: {
			...mapGetters('set', ['sets']),
		},
		methods: {
			...mapActions('set', ['fetchSets']),
		},
		mounted() {
			this.fetchSets()
		}
	}
</script>