<template>
  <div class="text-center">
    <v-dialog
      :model-value="isDialogActive"
      @update:model-value="switchDialog"
      width="500"
      style="margin: 0 auto;">

      <v-card min-width="500">
        <v-card-title class="text-h5 grey lighten-2 justify-center pt-2 bg-teal">
          <slot name="dialog-title"></slot>
        </v-card-title>

        <v-card-text>
					<slot></slot>
        </v-card-text>
        
        <v-divider></v-divider>

        <v-card-actions class="pt-3">
          <v-spacer></v-spacer>
					<slot name="dialog-actions"></slot>
          <v-btn @click="switchDialog(false)"
            color="primary" text>
						Close
          </v-btn>
        </v-card-actions>
      </v-card>
      
    </v-dialog>
  </div>
</template>

<script>
	import { mapState, mapMutations } from 'vuex'
	
	export default {
		computed: {
			...mapState(['isDialogActive']),
		},
		methods: {
			...mapMutations({
				switchDialog: 'switchDialog'
			})
		}
	}
</script>

<style>

</style>