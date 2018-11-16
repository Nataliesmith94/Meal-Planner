<template>
  <div id="app">
    <app-header></app-header>
    <nav-bar></nav-bar>
    <router-view/>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import navbar from '@/components/NavBar'

export default {
  components: {
    'app-header': Header,
    'nav-bar': navbar

  },
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
