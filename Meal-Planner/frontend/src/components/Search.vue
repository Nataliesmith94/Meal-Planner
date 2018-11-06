<template>
    <div>
        <input class="searchInput"
            placeholder="Search..."
            type="text"
            name="mealName"/>
        <button class="searchButton"
                type="submit" @click= "findMeal">
            Search
        </button>
    </div>
</template>

<script>
    import * as FindMealService from '@/services/findMealService';

    export default {
        methods: {
            findMeal(){
                try {
                    this.foundMeals = await FindMealService.findByMealName(this.mealName);
                } else {

                }
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

    button:hover {
        background-color: dodgerblue;
    }
</style>
