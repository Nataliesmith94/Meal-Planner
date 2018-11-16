<template>
    <div>
        <h2> Find a meal </h2>
        <search-id></search-id>
        <search--mealname></search--mealname>
    </div>
</template>

<script>
import Header from '@/components/Header'
import navbar from '@/components/NavBar'
import Search from '@/components/Search'
import SearchByID from '@/components/SearchByID'

export default {
  components: {
    'app-header': Header,
    'navbar': navbar,
    'search-Mealname': Search,
    'search-id': SearchByID
  }
}
</script>

<style>
    margin: 2px;
</style>
