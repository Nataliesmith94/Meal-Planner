<template>
  <form action="/action_page.php" method="get">
    <h2> This is the homepage </h2>
      <search></search>
  </form>
</template>

<script>
import Header from '@/components/Header.vue'
import Search from '@/components/Search.vue'

export default {
  components: {
    'app-header': Header,
    'search': Search
  },
  data () {
    return {
    }
  }
}
</script>

<style>
    h2 {
        padding-top: 50px;
    }
</style>
