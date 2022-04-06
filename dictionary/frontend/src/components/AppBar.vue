<template>

  <v-app-bar
      color="teal-darken-4"
      image="https://picsum.photos/1920/1080?random"
    >
      <template v-slot:image>
        <v-img
          gradient="to top right, rgba(19,84,122,.8), rgba(128,208,199,.8)"
        ></v-img>
      </template>

      <template v-slot:prepend>
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      </template>

      <v-app-bar-title>dictionary</v-app-bar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>
    
    <v-navigation-drawer
			v-model="drawer"
			temporary
		>
    <v-list-item
      prepend-avatar="https://randomuser.me/api/portraits/men/78.jpg"
      title="John Leider"
    ></v-list-item>

    <v-divider></v-divider>

    <v-list density="compact" nav>
      <v-list-item prepend-icon="mdi-view-dashboard" title="Home" value="home"></v-list-item>
      <v-list-item prepend-icon="mdi-forum" title="About" value="about"></v-list-item>
    </v-list>
  </v-navigation-drawer>
  
</template>

<script>
	export default {
		data () {
			return {
				drawer: null,
			}
		},
	}
</script>

<style>

</style>