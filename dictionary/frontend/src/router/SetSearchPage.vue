<template>
	<set-list :sets="sets"/>
</template>

<script>
	import SetList from '@/components/set/SetList.vue'
	import { mapActions, mapGetters } from 'vuex'
	
	export default {
		components: {
			SetList
		},
		computed: {
			...mapGetters('set', ['sets'])
		},
		methods: {
			...mapActions('set', ['fetchByTitle'])
		},
		created() {
			this.fetchByValue(this.$route.params.title)
		}
	}
</script>