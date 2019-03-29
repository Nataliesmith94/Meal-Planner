<template>
    <nav id="navbar">
        <ul>
            <li><router-link to="/planner/home-page">Home</router-link></li>
            <li><router-link to="/planner/add">Add Meal</router-link></li>
            <li><router-link to="/planner/search">Search for Meals</router-link></li>
        </ul>
    </nav>
</template>

<style>
    #navbar {
        display: inline-block;
        position: static;
        height: 5px;
        width: 100%;
        font-size: 20px;
        margin-top: 11px;
        margin-bottom: 2em;
        line-height: 7px;
        font-family: 'Quicksand', sans-serif;
        color: darkslategrey;
    }
    #navbar ul {
        list-style-type: none;
        margin-top: 10px;
        padding: 0;
        overflow: hidden;
        background-color: white;
        text-align: center;
        border-top: 2px solid grey;
        border-bottom: 3px solid grey;
    }

    #navbar li {
        display: inline-block;
        text-align: center;
        padding: 15px 30px 15px 30px;
        cursor: pointer;
        text-decoration: none;
    }

    #navbar li:hover {
        background-color: skyblue;
    }

</style>
