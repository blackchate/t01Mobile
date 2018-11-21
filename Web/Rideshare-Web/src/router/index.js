import Vue from 'vue'
import Router from 'vue-router'
import Rideshare from '@/components/Rideshare'
import FleetStatus from '@/components/FleetStatus'
import Rankings from '@/components/Rankings'
import User from '@/components/User'
//import FleetStatusOverview from '@/components/FleetStatusOverview'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Rideshare',
      component: Rideshare
    },
    {
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/rankings',
      name: 'Rankings',
      component: Rankings
    },
    {
      path: '/fleetstatus',
      name: 'FleetStatus',
      component: FleetStatus
    }
  ]
})
