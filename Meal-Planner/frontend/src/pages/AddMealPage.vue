<template>
    <div>
        <h2>Add A New meal</h2>
    </div>
</template>

<script>
import Header from '@/components/Header'
import TextQuestion from '@/components/questions/textQuestion'
import navbar from '@/components/NavBar'

export default {
  components: {
    'app-header': Header,
    'text-question': TextQuestion,
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
