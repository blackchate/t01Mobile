<template>
  <div class="rideshare">
    <h1>{{ msg }}</h1>
    <h2>Select a View</h2>
    <ul>
   
      <li><a href="http://localhost:8087/#/fleetstatus" target="_blank">Fleet Status Overview</a></li>
      <li><a href="http://localhost:8087/#/rankings" target="_blank">Rankings</a></li>

      <br>
     
    </ul>
 
  </div>
</template>

<script>
export default {
  name: 'rideshare',
  data () {
    return {
      msg: 'Rideshare Application'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
