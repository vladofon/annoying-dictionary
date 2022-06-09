<template>
	<v-list-item>
		<v-list-item-title>
			<v-btn @click="$emit('action')" :class="`text-${color}`" plain>{{text}}</v-btn>
		</v-list-item-title>
	</v-list-item>
</template>

<script>
	export default {
		props: ['color', 'text']
	}
</script>