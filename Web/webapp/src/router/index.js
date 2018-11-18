import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import FleetStatus from '@/components/FleetStatus'
import Rankings from '@/components/Rankings'

Vue.use(Router)

// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'HelloWorld',
//       component: HelloWorld
//     }
//   ]
// })

export default new Router({
    routes: [
      {
        path: '/',
        name: 'FleetStatus',
        component: FleetStatus
      },
      {
        path: '/User',
        name: 'User',
        component: User
      },
      {
        path: '/Rankings',
        name: 'Rankings',
        component: Rankings
      }
    ]
  })
