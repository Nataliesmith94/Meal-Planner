<template>
    <div>
        <label
            for="inputBox">
            MealName:
        </label>
        <input
            id="inputBox"
            v-model="inputBox"
            name="inputBox"
            placeholder="inputBox"
            type="text">
    </div>
</template>

<style>
 div {
     margin: auto;
     display: block;
 }
 label {
     display: inline-block;
     width: 100px;
     text-align: left;
     float: left;
     padding: 9px;
 }

 input {
     display: inline-block;
 }
</style>
