<template>
    <div class="inputbox">
        <label
            :for="name"
            label="inputBox">
            {{ label }}
        </label>
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
    type: {
      type: String,
      default: 'text'
    },
    value: {
      type: [String, Number],
      default: ''
    },
    placeholder: {
      type: String,
      default: ''
    },
    label: {
      type: String,
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
