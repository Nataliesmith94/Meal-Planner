<template>
    <div class="inputListBox">
        <div
            class="container"
            id="container">
            <label
                :for="name"
                label="inputBox">
                {{ label }}
            </label>
            <input
                :id="name"
                :name="name"
                :placeholder="placeholder"
                :type="type"
                :value="value"
                @input="$emit('input', $event.target.value)"/>
            <button
                class="addButton"
                @click="addNewRow"> Add </button>
            <button
                class="removeButton"
                @click="removeLastRow"> Remove </button>
        </div>
    </div>
</template>

<script>
export default {
  name: 'inputListBox',
  data () {
    return {
      items: [
          {text: "ingrediants 1"},
          {text: "ingrediants 2"}
      ]
    }
  },
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
  },
  methods: {
    addNewRow () {
      console.log('Add New Row')
      var container = document.getElementById("container");
      var input = document.createElement("input");
      var button = document.createElement("button");

      input.appendChild(button);

      input.type = "text";
      input.id = "row1";
      input.setAttribute("Placeholder", "New ingrediant");
      container.appendChild(input);

        if(input.value !== '') {
            this.items.push({
                text: input.value
            })
            input.value = "";
        }

        console.log(this.items)
    },

    removeLastRow () {
        var container = document.getElementById("container");
        container.lastElementChild.remove();
    }
  }
}
</script>

<style>
 .inputListBox {
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

 .addButton {
     border-radius: 50%;
 }
</style>
