<template>

    <div class="rankings">

        <h1>Rankings</h1>

            <div class="medium-6 medium-offset-3 ctrl">
        <form class="searchForm" v-on:submit.prevent="submitSearch">
          <input type="text" placeholder="search..." style="text-align:center; margin-bottom:30px">
        </form>
      </div>

    <div>
      <div class="passengers table">
        <h3>LOYAL PASSENGERS</h3>
        <span>Name</span>
        <span>----</span>
        <span>Number of Trips</span>
        <ul v-for="p in passengers">
          <span>{{p.firstName}} {{p.lastName}}</span>
          <span>----</span>
          <!-- TODO: replace with p.numberOfTrips -->
          <span>{{ p.age }}</span>
        </ul>
      </div>

      <div class="drivers table">
        <h3>TOP DRIVERS</h3>
        <span>Name</span>
        <span>----</span>
        <span>Rating</span>
        <!-- will try to add links for more info -->
        <!-- will sort and display them in order -->
        <!-- TODO: replace with d.rating-->
        <ul v-for="d in drivers">
          <span>{{d.firstName}} {{d.lastName}}</span>
          <span>----</span>
          <span>{{d.age}}</span>
        </ul>
      </div>

        <!-- not sure how to do this. Maybe count number of souce - destination pairs -->
        <!-- will try to link to google maps for bonus -->
      <div class="routes table">
        <h3>POPULAR ROUTES</h3>
        <!-- add style -->
        <span>source</span>
        <span>---></span>
        <span>destination</span>
        <span>arrival time</span>
        <ul v-for="t in trips">
          <span>{{ t.pickUpLocation }}</span>
          <span>---></span>
          <span>{{ t.destination }}</span>
          <span>{{ t.arrivalTime }}</span>
        </ul>
      </div>
    </div>

    </div>

</template>



<script src="./script.js">

export default {

    name: 'Rankings',

    data() {

        return {

            

        }

    }

}

</script>



<style>



</style>