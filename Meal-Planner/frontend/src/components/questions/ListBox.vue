<template>
    <div class="ListBox">
        <div class="inputContainer">
            <label
                :for="name"
                label="ListBox">
                {{ label }}
            </label>
            <input
                :name="name"
                id="listBox"
                :placeholder="placeholder"
                :type="type"
                v-on:keypress.enter="addItem"/>
           <img
               class="addItemIcon"
               src="/static/svg/add2.svg"
               @click="addItem"/>
        </div>
       <ul>
           <li class='listContainer'
               v-for="(item, index) in items" :key="index">
               <img
                   class="removeItemIcon"
                   src="/static/svg/remove.svg"
                   @click="deleteItem(index)">
               <p class="listItem">
                   {{ item.text }}
               </p>
           </li>
       </ul>
    </div>
</template>

<script>

export default {
  name: 'inputListBox',
  data () {
    return {
      items: []
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
      var input = document.getElementById('listBox')

      if (input.value !== '') {
        this.items.push({
          text: input.value
        })
        input.value = ''
      }
      console.log(this.items)
    },
    deleteItem: function (index) {
      this.items.splice(index, 1)
    }
  }
}
</script>

<style>
 .ListBox {
     margin: auto;
     display: block;
     flex-direction: row;
     margin: 10px;
     position: relative;
     left: 19px;
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
 }

 li {
     display: block;
     list-style: none;
     text-align: left;
     padding-left: 78px;
 }

 .addItemIcon {
     width: 30px;
     height: 30px;
     display: flex;
     align-items: center;
     margin-left: 3px;
     padding-top: 6px;
 }

 .removeItemIcon {
     width: 30px;
     height: 30px;
 }

 .inputContainer {
     display: flex;
     justify-content: center;
 }

 .listContainer {
     display: flex;
     line-height: 30px;
     padding-left: 95px;
     padding-top: 10px;
 }

 listContainer:first-child {
     margin-top: 8px;
 }

 .listItem {
     margin: 1px;
     margin-left: 4px;
 }
</style>
