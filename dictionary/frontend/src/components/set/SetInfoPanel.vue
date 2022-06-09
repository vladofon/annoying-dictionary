<template>
	<v-col cols="12" class="mt-10">
		<v-card color="#952175" theme="dark">
			<div class="d-flex flex-no-wrap justify-space-between">
				<div>
				
					<v-card-title class="text-h5"> 
						{{set.title}}
					</v-card-title>
		
					<v-card-subtitle> 
						{{set.description}}
					</v-card-subtitle>
		
					<v-card-actions> 
						<slot name="actions"></slot>
					</v-card-actions>
					
				</div>
				
				<v-avatar class="ma-3" size="125" rounded="0"> 
					<v-img src="https://cdn.vuetifyjs.com/images/cards/halcyon.png"></v-img>
				</v-avatar>
				
			</div>
		</v-card>
	</v-col>
</template>

<script>
	export default {
		props: ['set']
	}
</script>