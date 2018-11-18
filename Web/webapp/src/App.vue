<template>
  <div id="app">
    <h1>DRIVESHARE</h1>
    <FleetStatus />
    <Rankings />
  </div>
</template>

<script>

import FleetStatus from './components/FleetStatus'
import Rankings from './components/Rankings'

export default {
  name: 'App',
  components: {
    FleetStatus,
    Rankings
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
