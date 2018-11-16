<template>
    <question
        :label = "label"
        :name = "name"
        :errorMessage = "errorMessage">
        <input
          :maxlength="maxLength"
          type="text"
          :id="name"
          :name="name"
          :value="value"
          :placeholder="placeholder"
          class="input"/>
    </question>

</template>

<script>
import Question from '@/components/questions/Question.vue'

export default {
  name: 'Text Question',

  components: {
    question: Question
  },

  props: {
    name: {
      type: String,
      required: true
    },
    label: {
      type: String,
      default: ''
    },
    placeholder: {
      type: String,
      default: ''
    },
    value: {
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

<style scoped>
    .label {
      display: inline-block;
      line-height: 1.4;
      padding: 0 30px 10px 0;
    }
    .input {
        padding: 16px 15px 17px;
        font-family: inherit;
        font-size: 16px;
        font-weight: 600;
        line-height: 1.4;
        border-radius: 6px;
        display: inline-block;
    }
</style>
