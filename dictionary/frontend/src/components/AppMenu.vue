<template>
	<v-menu v-model="menu" transition="scale-transition" :close-on-content-click="true">
		<template v-slot:activator="{ props }">
			<v-btn v-bind="props" flat icon="mdi-dots-vertical" class="align-self-start"></v-btn>
		</template>
		
		<v-list elevation="5" rounded class="pa-0" @click="menu = false">
		
			<slot></slot>
	
		</v-list>
	</v-menu>
</template>

<script>
	export default {
		data() {
			return {
				menu: false
			}
		}
	}
</script>