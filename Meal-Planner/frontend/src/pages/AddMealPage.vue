<template>
<div>
    <h2>Add A New meal</h2>
    <ul>
        <input-box
            id="MealName"
            v-model="MealName"
            name="MealName"
            label="Meal Name:"
            placeholder="Please enter the meal name..."
            type="text"/>

        <input-box
            name="Ingredients"
            id="Ingredients"
            v-model="Ingredients"
            label="Ingredients:"
            placeholder="Please enter the Ingredients used..."
            type="text"/>

        <input-box
            name="PrepTime"
            id="PrepTime"
            label="PrepTime:"
            placeholder="Please enter the prep time used..."
            type="number"
            v-model="PrepTime"/>

        <input-box
            name="CookingTime"
            id="CookingTime"
            label="CookingTime:"
            placeholder="Please enter the Cooking Time needed..."
            type="number"
            v-model="CookingTime"/>

        <input-box
            name="Categories"
            id="Categories"
            label="Categories:"
            placeholder="Please select the cateogry..."
            type="text"
            v-model="Categories"/>

        <input-box
            name="Source"
            id="Source"
            label="Source:"
            placeholder="Please Enter the Source..."
            type="text"
            v-model="Source"/>

        <input-box
            name="Author"
            id="Author"
            label="Author:"
            placeholder="Please Enter the Author..."
            type="String"
            v-model="Author"/>

        <button
            class="btn__submit"
            @click="postRequest"
        > Submit
        </button>
    </ul>
    <p>Meal Name: {{ MealName }}</p>
</div>
</template>

<script>
import Header from '@/components/Header'
import inputBox from '@/components/questions/inputBox'
import navbar from '@/components/NavBar'
import axios from 'axios'

export default {
  components: {
    'app-header': Header,
    'input-box': inputBox,
    'navbar': navbar
  },
  data () {
    return {
      MealName: '',
      Ingredients: '',
      PrepTime: 0,
      CookingTime: 0,
      Categories: '',
      Source: '',
      Author: ''
    }
  },
  methods: {
    postRequest () {
      axios.post('http://localhost:9000/api/plannerDB/add', {
        mealName: this.MealName,
        ingredients: ['Test1', 'test2'],
        method: ['Test1', 'test2'],
        prepTime: this.prepTime,
        cookingTime: this.cookingTime,
        categories: ['Test1', 'test2'],
        author: this.author
      })
        .then(response => {
          this.result = response.data
          console.log(this.result)
        })
        .catch(e => {
          console.log(e)
        })
    }
  }
}
</script>

<style>
    button {
        width: 50px;
        height: 50px;
        background-color: skyblue;
    }

    ul {
        display: block;
    }

    h2 {
        position: relative;
        padding-top: inherit;

    }

    input {
        width: 20%;
        font-size: 16px;
        padding: 10px;
        float: left;
        border: 2px solid slategrey;
        background-color: white;
    }
</style>
