<template>
    <div class="form-group">
        <input
            id="mealName"
            v-model="mealName"
            name="mealName"
            class="searchInput"
            placeholder="Search by meal name..."
            type="text"/>
        <button
            class="searchButton"
            type="submit"
            v-on:click = "findMeal">
            Search  </button>
        <ul class="search-result">
            <li v-for= "(meal, index) in mealCollection" :key="index">
                <h6>
                    {{ meal.mealName }}
                </h6>
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      mealCollection: [], // Array
      mealName: '' // String
    }
  },
  methods: {
    findMeal () {
      axios.get('http://localhost:9000/api/search/findByMealName/' + this.mealName)
        .then(response => {
          this.mealCollection = response.data
          console.log(this.mealCollection)
        })
        .catch(e => {
          console.log(e)
        })
    }
  }
}

</script>

<style>
    .form-group {
        padding-top: 60px;
    }
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
        background-color: forestgreen;
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
