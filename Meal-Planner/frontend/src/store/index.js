import Vue from 'vue';
import Vuex from 'vuex';

import {getField, updateField} from 'vuex-map-fields';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        recipeId: null,
        mealName: null,
        ingredients: null,
        method: null,
        prepTime: null,
        cookingTime: null,
        categories: null,
    },
    getters: {
        getField,
    },
    mutations: {
        updateField,
    },
});
