<template>
    <div class="inputListBox">
        <input id="inputItem" v-on:keypress.enter="addItem"/>
        <button @click="addItem">
            Add
        </button>
       <ul>
           <li v-for="(item, index) in items">
               <button @click="deleteItem(index)">X</button>
               {{ item.text }}
           </li>
       </ul>
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
    addItem () {
        var input = document.getElementById('inputItem');

        if(input.value !== '') {
            this.items.push({
                text: input.value
            })
            input.value = "";
        }
        console.log(this.items);
    },
    deleteItem: function (index) {
        this.items.splice(index, 1);
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
