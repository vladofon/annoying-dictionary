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
	
	import { mapMutations, mapGetters, mapActions } from 'vuex'
	
	export default {
		components: {
			SetHeader,
			// WordList,
			WordForm,
			WordDialog
		},
		computed: {
			...mapGetters('set', ['sets']),
		},
		methods: {
			...mapActions('set', ['fetchSet']),
			...mapMutations('set', ['setOperableSet']),
		},
		mounted() {
			this.fetchSet(this.$route.params.id)
			
			this.setOperableSet({
				id: this.$route.params.id, 
				title: '', 
				description: ''
			})
		}
	}
</script>