<template>
<div>
    <h2 class="heading">Add A New meal</h2>
    <ul class="container">
        <div>
            <input-box
                id="MealName"
                name="MealName"
                label="Meal Name:"
                placeholder="Please enter the meal name..."
                type="text"
                v-model="recipe.MealName"/>

            <list-box
                id="Ingredients"
                name="Ingredients"
                label="Ingredients:"
                placeholder="Please enter the Ingredients used..."
                type="text"
                v-model="recipe.Ingredients"/>

            <input-box
                id="PrepTime"
                name="PrepTime"
                label="PrepTime:"
                placeholder="Please enter the prep time used..."
                type="number"
                v-model="recipe.PrepTime"/>

            <input-box
                id="CookingTime"
                name="CookingTime"
                label="CookingTime:"
                placeholder="Please enter the Cooking Time needed..."
                type="number"
                v-model="recipe.CookingTime"/>

            <input-box
                id="Method"
                name="Method"
                label="Method:"
                placeholder="Please enter the method..."
                type="text"
                v-model="recipe.Method"/>

            <list-box
                id="Categories"
                name="Categories"
                label="Categories:"
                placeholder="Please select the cateogry..."
                type="text"
                v-model="recipe.Categories"/>

            <input-box
                id="Source"
                name="Source"
                label="Source:"
                placeholder="Please Enter the Source..."
                type="text"
                v-model="recipe.Source"/>

            <input-box
                id="Author"
                name="Author"
                label="Author:"
                placeholder="Please Enter the Author..."
                type="String"
                v-model="recipe.Author"/>

            <button
                class="btn__submit"
                @click="postRequest"
            > Submit
            </button>
        </div>
    </ul>
    <p> {{ result }} </p>
</div>
</template>

<script>
import Header from '@/components/Header'
import inputBox from '@/components/questions/inputBox'
import inputListBox from '@/components/questions/inputListBox'
import ListBox from '@/components/questions/ListBox'
import navbar from '@/components/NavBar'
import axios from 'axios'
import { mapFields } from 'vuex-map-fields'

export default {
  components: {
    'app-header': Header,
    'input-box': inputBox,
    'navbar': navbar,
    'input-list-box': inputListBox,
    'list-box': ListBox
  },
  data () {
    return {
      recipe: {
        MealName: '',
        Ingredients: [],
        PrepTime: 0,
        CookingTime: 0,
        Method: [],
        Categories: [],
        Source: '',
        Author: ''
      },
      result: null
    }
  },
  computed: {
    ...mapFields([
      'MealName',
      'Ingredients',
      'PrepTime',
      'CookingTime',
      'Method',
      'Categories',
      'Source',
      'Author'
    ])
  },
  methods: {
    postRequest () {
      var data = {
        mealName: this.recipe.MealName,
        ingredients: ['Test1', 'test2'],
        prepTime: this.recipe.PrepTime,
        cookingTime: this.recipe.CookingTime,
        categories: ['Test1', 'test2'],
        method: ['Test1', 'test2'],
        author: this.recipe.Author
      }
      axios.post('http://localhost:9000/api/plannerDB/add', data)
        .then(response => {
          this.result = response.data
          console.log(this.result)
        })
        .catch(e => {
          console.log(e)
        })
      this.resetForm()
    },

    resetForm () {
      console.log('resetting form')
      this.recipe = {}
    }
  }
}
</script>

<style>
    @import url('https://fonts.googleapis.com/css?family=Quicksand');

    button {
        width: 50px;
        height: 50px;
        background-color: skyblue;
    }

    .container {
        display: block;
    }

    h2 {
        position: relative;
        padding-top: inherit;
    }

    input {
        width: 70%;
        font-size: 16px;
        padding: 10px;
        float: left;
        border: 2px solid slategrey;
        background-color: white;
    }

    .btn__submit {
        width: 120px;
        height: 55px;
        border-radius: 20px;
        background-color: #5294DF;
        font-size: 14px;
    }

    .heading {
        font-family: 'Quicksand', sans-serif;
        font-size: 30px;
        font-weight: 700;
    }
</style>
