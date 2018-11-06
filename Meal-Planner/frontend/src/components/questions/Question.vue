<template>
  <li
    class = "row question"
    :class="{'question-error' : errorMessage}"
    :id="`${name}Question`">
    <div v-if="label"
      class="column">
      <div class="question__body">
         <div
            class="warning"
            v-show="errorMessage" >
            <span class="warning_message">{{ errorMessage }}</span>
                </div>
                <div class="question__heading">
                    <label
                        :for="name"
                        class="question__label">{{ label }}</label>
                    <p v-if="hint" class="question__hint">{{hint}}</p>
                </div>
            </div>
        </div>
    </li>
</template>

<script>
export default {
  name: 'Question',

  props: {
    name: {
      type: String,
      required: true
    },
    label: {
      type: String,
      default: ''
    },
    errorMessage: {
      type: String,
      default: ''
    }
  }
}

</script>

<style>
    .question {
        box-sizing: border-box;
        margin: 0 -20px;
        padding: 15px 20px;
        position: relative;
        transition: all 0.2s ease-in-out;
    }

    label {
        float: left;
        margin-right: 1em;
        display: inline-block;
        width: 300px;
        text-align: left;
    }

    li {
        list-style-type: none;
    }
</style>
