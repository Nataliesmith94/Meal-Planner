<template>
    <div>
        <app-header></app-header>
        <h2>Add A New meal</h2>
        <text-question
        name="MealName"
        label="Please Type your new meal Name"
        tabindex="0"
        type="text"
        placeholder="e.g Chicken pie">
        </text-question>

        <input-box
        id="mealName"
        name="mealName"
        tabindex="0"
        type="text"
        placeholder="e.g Chicken Curry">
        </input-box>

        <button
        type = "button"> Enter </button>
    </div>
</template>

<script>
import Header from '@/components/Header'
import InputBox from '@/components/questions/testInputQuestion'
import TextQuestion from '@/components/questions/textQuestion'

export default {
  components: {
    'app-header': Header,
    'input-box': InputBox,
    'text-question': TextQuestion
  }
}
</script>

<style>
    h2 {
        padding-top: 50px;
    }

    label {

    }
</style>
