<template>
  <div id="app">
    <nav v-if="isLoggedIn">
      <router-link to="/">Home</router-link> |
      <a href="#" @click="logout">Logout</a>
    </nav>
    <nav v-else>
      <router-link to="/login">Login</router-link> |
      <router-link to="/register">Register</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  computed: {
    isLoggedIn() {
      return !!localStorage.getItem('token')
    }
  },
  methods: {
    logout() {
      localStorage.removeItem('token')
      this.$router.push('/login') }
  }
}
</script>