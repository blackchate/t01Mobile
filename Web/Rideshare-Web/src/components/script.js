import axios from 'axios';

//// calling backend

const frontendUrl = 'http://localhost:8087/'; // change before deploying
const backendUrl = 'https://shrouded-fjord-72003.herokuapp.com/';
//const backendUrl = 'https://eventregistration-backend-123.herokuapp.com/';

var AXIOS = axios.create({
  baseURL: backendUrl
});


////

function ParticipantDto (name) {
  this.name = name
  this.events = []
}

function EventDto (name, date, start, end) {
  this.name = name
  this.eventDate = date
  this.startTime = start
  this.endTime = end
}

//function drivers()

export default {
  name: 'eventregistration',
  data () {
    return {
      drivers: [],
      passengers: [],
      trips: [],
    }
  },
  created: function () {

      AXIOS.get(`/drivers`) // change to /drivers/active once ellina is done
      .then(response => {
        console.log(response.data);
        this.drivers = response.data
      })
      .catch(e => {
        this.errorParticipant = e;
      });

      AXIOS.get(`/passengers`) // change to /passengers/active once ellina is done
      .then(response => {
        console.log(response.data);
        this.passengers = response.data
      })
      .catch(e => {
        this.errorParticipant = e;
      });

      AXIOS.get(`/trips`) //change to /trips/active once ellina is done
      .then(response => {
        console.log(response.data);
        this.trips = response.data
      })
      .catch(e => {
        this.errorParticipant = e;
      });

  },
methods: {
  createParticipant: function (participantName) {
    // Create a new participant and add it to the list of participants
    var p = new ParticipantDto(participantName)
    this.participants.push(p)
    // Reset the name field for new participants
    this.newParticipant = ''
  }
}
}

