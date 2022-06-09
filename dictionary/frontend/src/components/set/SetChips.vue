<template>
	<v-col cols="12" class="text-center"> 
	
		<v-chip class="ma-2" color="green" text-color="white" prepend->
			<template v-slot:prepend>
				<v-avatar class="green-darken-6"> 360 </v-avatar>
			</template>
			Words 
		</v-chip> 
	
		<v-chip class="ma-2" color="green" text-color="white" append-icon="mdi-playlist-check" prepend->
			<template v-slot:prepend>
				<v-avatar class="green-darken-6"> 15 </v-avatar>
			</template>
			Subscribtions 
		</v-chip> 
	
		<v-chip class="ma-2" color="orange" text-color="white" append-icon="mdi-star"> 
			Top-10 
		</v-chip> 
	
	</v-col>
</template>