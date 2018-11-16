<template>
    <div class="form-group-id">
        <input
            id="mealName"
            v-model="mealName"
            name="inputID"
            class="searchInput"
            placeholder="Search by id..."
            type="text"/>
        <button
            class="searchButton"
            type="submit"
            v-on:click="findMeal">
            Search
        </button>
        <ul class="search-result">
            <h6 v-if="meal">
                {{ meal.mealName }}
                <!--{{meal.ingredients}}-->
                <!--{{meal.method}}-->
                <!--{{meal.cookingTime}}-->
                <!--{{meal.categories}}-->
                {{ meal.author }}
            </h6>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      meal: [],
      mealName: '',
      author: ''
    }
  },
  methods: {
    findMeal () {
      axios.get('http://localhost:9000/api/search/findByID/' + this.mealName)
        .then(response => {
          this.meal = response.data
          console.log(this.meal)
        })
        .catch(e => {
          console.log(e)
        })
    }
  }
}

</script>

<style>
    input {
        width: 20%;
        font-size: 16px;
        padding: 10px;
        float: left;
        border: 2px solid slategrey;
        background-color: white;
    }

    button {
        width: 10%;
        float: left;
        padding: 10px;
        color: green;
        font-size: 16px;
        cursor: pointer;
        border: 2px solid slategrey;
        background-color: steelblue;
        color: white;
    }

    .search-result {
        position: relative;
        margin-top: 30px;
        text-align: left;
    }

    button:hover {
        background-color: dodgerblue;
    }

    h6 {
        margin-right: 40%;
        padding-left: 50px;
        align-content: right;
        text-align: right;
        font-size: 40px;
    }
</style>
