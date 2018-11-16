<template>
  <form action="/action_page.php" method="get">
      <navbar></navbar>
    <h2> {{ msg }} </h2>
  </form>
</template>

<script>
import Header from '@/components/Header.vue'
import navbar from '@/components/NavBar'
import axios from 'axios'

export default {

  async mounted () {
    const {data} = await axios.get('http://localhost:9000/api/welcome')
    this.msg = data
    console.log(this.msg)
  },

  components: {
    'app-header': Header,
    'navbar': navbar
  },

  data () {
    return {
      msg: null
    }
  }
}
</script>

<style>
    h2 {
        padding-top: 50px;
    }
</style>
