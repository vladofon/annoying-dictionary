<template>
	<word-form/>
	<set-header :set="sets[0]"/>
	<!-- <word-list/> -->
	<word-dialog/>
</template>

<script>
	import SetHeader from '@/components/set/SetHeader.vue'
	// import WordList from '@/components/word/WordList.vue'
	import WordForm from '@/components/word/WordForm.vue'
	import WordDialog from '@/components/word/WordDialog.vue'
	
	import { mapState, mapActions } from 'vuex'
	
	export default {
		components: {
			SetHeader,
			// WordList,
			WordForm,
			WordDialog
		},
		computed: {
			...mapState('set', ['sets'])
		},
		methods: {
			...mapActions('set', ['fetchSet'])
		},
		mounted() {
			this.fetchSet(this.$route.params.id)
		}
	}
</script>