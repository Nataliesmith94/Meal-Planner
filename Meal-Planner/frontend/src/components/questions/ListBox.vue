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
            <!--<button-->
                <!--class="addItem"-->
                <!--@click="addItem">-->
                <!--<img class="addIcon" src="/static/svg/add2.svg"/>-->
            <!--</button>-->
        </div>
       <ul>
           <li v-for="(item, index) in items">
               <img
                   class="removeItemIcon"
                   src="/static/svg/remove.svg"
                   click="deleteItem(index)">
               <p class="listItem">
                   {{ item.text }}
               </p>
               <!--<button-->
                   <!--class="deleteItem"-->
                   <!--@click="deleteItem(index)">-->
                   <!--X-->
               <!--</button>-->

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
     width: 35px;
     height: 35px;
     display: flex;
     align-items: center;
 }

 .removeItemIcon {
     width: 35px;
     height: 35px;
 }

 .inputContainer {
     display: flex;
 }

 .addItem {
     border-radius: 50%;
     margin-left: 10px;
 }

 .deleteItem {
     width: 42px;
     height: 42px;
 }
</style>
