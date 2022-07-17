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

			<v-text-field
				@click:prepend-inner="search"
				@keyup.enter="search"
				v-model="searchValue"
				label="Search"
				variant="outlined"
				density="compact"
				prepend-inner-icon="mdi-magnify"
				class="mr-3"
			></v-text-field>

      <v-btn icon>
				<a v-if="!isAuthenticated" @click.prevent="login">
					<v-icon>mdi-login</v-icon>
				</a>
				<a v-else @click.prevent="logout">
					<v-icon>mdi-logout</v-icon>
				</a>
      </v-btn>
    </v-app-bar>
    
    <v-navigation-drawer
			v-model="drawer"
			temporary
		>
    <v-list-item
      :prepend-avatar="profile.userpic"
      :title="profile.name"
    ></v-list-item>

    <v-divider></v-divider>

    <v-list density="compact" nav>
      <v-list-item @click="$router.push('/profile')" prepend-icon="mdi-account-box" title="Profile" value="profile"></v-list-item>
      <v-list-item @click="$router.push('/sets')" prepend-icon="mdi-view-dashboard" title="Sets" value="sets"></v-list-item>
      <v-list-item @click="$router.push('/words')" prepend-icon="mdi-forum" title="Words" value="words"></v-list-item>
    </v-list>
  </v-navigation-drawer>
  
</template>

<script>
	import { mapGetters } from 'vuex'
	
	export default {
		data () {
			return {
				drawer: null,
				searchValue: '',
			}
		},
		computed: {
			...mapGetters('profile', ['isAuthenticated']),
			...mapGetters('profile', ['profile']),
		},
		methods: {
			login() {
				window.location.href = "http://localhost:8080/sessions/Google/callback";
			},
			logout() {
				window.location.href = "http://localhost:8080/logout";
			},
			search() {
				this.$router.push('/search/' + this.searchValue)
				this.searchValue = ''
			}
		}
	}
</script>

<style>

</style>