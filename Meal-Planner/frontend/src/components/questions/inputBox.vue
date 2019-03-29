<template>
    <div class="inputbox">
        <label
            class="inputbox__label"
            :for="name"
            label="inputBox">
            {{ label }}
        </label>
        <input
            class="inputbox__input"
            :name="name"
            :id="name"
            :placeholder="placeholder"
            :type="type"
            :value="value"
            @input="$emit('input', $event.target.value)"/>
    </div>
</template>

<script>
export default {
  name: 'inputBox',
  props: {
    name: {
      type: String,
      required: true
    },
    id: {
      type: String,
      required: false
    },
    type: {
      type: String,
      default: 'text'
    },
    placeholder: {
      type: String,
      default: ''
    },
    label: {
      type: String,
      default: ''
    },
    value: {
      type: [String, Number],
      default: ''
    }
  }
}
</script>
<style>
 .inputbox {
     margin: auto;
     display: flex;
     flex-direction: row;
     margin: 10px;
     justify-content: center;
     width: 700px;
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
     border-radius: 6px;
 }
</style>
