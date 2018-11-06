const ENDPOINT = `${window.CONTEXT_PATH}/search/findByMealName`;

export const findByMealName = mealName => get(`${ENDPOINT}?mealName=${mealName}`);
