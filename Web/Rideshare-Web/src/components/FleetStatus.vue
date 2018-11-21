<template>
  <div id="fleetstatus">
    <h2 style="margin-bottom: 50px;">Fleet Status Overview</h2>

    <div class="medium-6 medium-offset-3 ctrl">
        <form class="searchForm" v-on:submit.prevent="submitSearch">
          <input type="text" placeholder="search..." style="text-align:center; margin-bottom:30px">
        </form>
      </div>

    <!-- TODO: add some styling -->
    <div>
      <div class="drivers table">
        <h3>ACTIVE DRIVERS</h3>
        <span>Name</span>
        <span>----</span>
        <span>Age</span>
        <ul v-for="d in drivers">
          <span>{{d.firstName}} {{d.lastName}}</span>
          <span>----</span>
          <span>{{d.age}}</span>
        </ul>
      </div>

      <div class="passengers table">
        <h3>ACTIVE PASSENGERS</h3>
        <span>Name</span>
        <span>----</span>
        <span>Current or Latest Trip</span>
        <ul v-for="p in passengers">
          <span>{{p.firstName}} {{p.lastName}}</span>
          <span>----</span>
          <!-- TODO: replace with p.numberOfTrips -->
          <span>{{ p.trip[0].pickUpLocation }}</span>
        </ul>
      </div>

      <div class="routes table">
        <h3>ACTIVE ROUTES</h3>
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

        <!-- <td>Active Drivers</td>
        <tr v-for="driver in drivers" >
          <td>
            <td>{{ passenger.firstName }}</td>
          </td>
        </tr>

        <td>Active Passengers</td>
        <tr v-for="passenger in passengers" >
          <td>{{ passenger.firstName }}</td>
        </tr>

        <td>Active Routes</td>
        <tr v-for="passenger in passengers" >
          <td>{{ passenger.firstName }}</td>
        </tr> -->

      <!-- <tr>
          <td>
            <input type="text" v-model="newParticipant" placeholder="Participant Name">
          </td>
          <td>
              <button @click="createParticipant(newParticipant)">Create Passenger</button>
          </td>
      </tr> -->

    <p>
      <span v-if="errorParticipant" style="color:red">Error: {{errorParticipant}} </span>
    </p>
  </div>
</template>

<script src="./script.js">
  
</script>



<style>
  #rideshare {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: #f2ece8;
  }

  .overview {
    display: flex;
  }

  a {
    color: inherit;
  }



  /* style for search bar */

</style>
