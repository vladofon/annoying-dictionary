<template>

	<v-container fluid class="bg-teal ">
		<v-row>
			<v-col class="d-flex" :class="{'justify-center': center}">
				<h3 class="text-white">
					<slot></slot>
				</h3>
			</v-col>
		</v-row>
	</v-container>
	
</template>

<script>

export default {
	props: ['center']
}

</script>