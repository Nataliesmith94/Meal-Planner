<template>
    <div>
        <h2>Add A New meal</h2>
        <input-box></input-box>
    </div>
</template>

<script>
import Header from '@/components/Header'
import inputBox from '@/components/questions/inputBox'
import navbar from '@/components/NavBar'

export default {
  components: {
    'app-header': Header,
    'input-box': inputBox,
    'navbar': navbar
  },
  method: {
  }
}
</script>

<style>
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
