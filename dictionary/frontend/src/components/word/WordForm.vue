<template>

	<v-container fluid class="bg-teal ">
		<v-row>
			<v-col class="d-flex">
				<h3 class="text-white" style="margin: auto 0">Words set</h3>
				<v-spacer></v-spacer>
				<div>
					<v-btn @click="createWord" rounded="pill" class="text-black">
						<v-icon color="black">mdi-plus</v-icon>
						Add new
					</v-btn>
				</div>
			</v-col>
		</v-row>
		
	</v-container>
</template>

<script>
import { mapMutations } from 'vuex'
import DialogModes from '@/components/word/misc/DialogModes'

export default {
	methods: {
		...mapMutations({
			switchDialog: 'switchDialog'
		}),
		...mapMutations('word', ['setDialogMode', 'setOperableWord']),
		
		createWord() {
			this.setDialogMode(DialogModes.CREATE)
			this.setOperableWord({id:null, value:'', context:''})
			this.switchDialog(true)
		}
	}
}
</script>

<style>

</style>