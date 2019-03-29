<template>
  <header>
      <div>
          <h1> {{title}} </h1>
          <button>
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0h24v24H0z" fill="none"/><path d="M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z"/></svg>
          </button>
      </div>
  </header>
</template>

<script>
export default {
  data () {
    return {
      title: 'Vue Application'
    }
  }
}
</script>

<style>
  header {
      width: 100%;
      height: 50px;

      position: fixed;
      padding: 15px;
      top: 0;
      left: 0;
      z-index: 5;

      background: #25b99a;
      box-shadow: 0px 2px 4px rgba(44, 62, 80, 0.15);
      border-bottom-right-radius: 10px;
      border-bottom-left-radius: 10px;
  }

  header h1 {
      font-family: 'Quicksand', sans-serif;
      font-weight: 700;
      color: darkslategrey;
      text-align: center;
      margin: 0px;
  }

  header button {
      width: 50px;
      height: 50px;

      position:absolute;
      top:20px;
      right:50px;
      z-index:2;

      border-radius: 25px;
      background: #fff;
      border: 0px;
      box-shadow: none;
      outline: none;
      cursor: pointer;

      -webkit-appearance: none;
      -moz-appearance: none;
      -ms-appearance: none;
      -o-appearance: none;
      appearance: none;
  }

  header button svg {
      width: 16px;
      height: 16px;

      position: absolute;
      top: 50%;
      left: 50%;

      margin: -8px 0 0 -8px;
  }

  header button svg .fill {
      fill: #25b99a;
  }
</style>
