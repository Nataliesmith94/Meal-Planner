import Vue from 'vue'
import Router from 'vue-router'

const HomePage = () => import('@/pages/HomePage')
const AddMealPage = () => import('@/pages/AddMealPage.vue')

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: 'planner/',
      redirect: {name: HomePage}
    },
    {
      path: '/planner/home-page',
      name: 'Home Page',
      component: HomePage,
      step: true
    },
    {
      path: '/planner/add',
      name: 'Add New Meal',
      component: AddMealPage,
      step: true
    }
  ],
  mode: 'history',
  scrollBehavior () {
    return { x: 0, y: 0 }
  }
})
