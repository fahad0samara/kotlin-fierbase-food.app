package com.fahad.tastybite.data.local

import com.fahad.tastybite.R

enum class FoodType {
  Appetizer, MainCourse, Dessert, Snack, Beverage
}

data class FoodItem(
  val name: String,
  val chef: String,
  val description: String,
  val imageResId: Int,
  val price: Double,
  val foodType: FoodType,
  val calories: Int,
  val servingSize: Int
)

val availableFoods = listOf(
  FoodItem(
    "Margherita Pizza",
    "Chef Mario",
    "Classic pizza topped with fresh tomatoes, mozzarella, and basil. A timeless favorite!",
    R.drawable.pizza_margherita,
    12.99,
    FoodType.MainCourse,
    800,
    1
  ),
  FoodItem(
    "Chicken Alfredo Pasta",
    "Chef Carla",
    "Creamy Alfredo sauce with grilled chicken served over perfectly cooked pasta.",
    R.drawable.chicken_alfredo_pasta,
    15.99,
    FoodType.MainCourse,
    1200,
    1
  ),
  FoodItem(
    "Chocolate Brownie Sundae",
    "Chef Emily",
    "Warm chocolate brownie topped with vanilla ice cream, chocolate sauce, and whipped cream.",
    R.drawable.chocolate_brownie_sundae,
    8.99,
    FoodType.Dessert,
    600,
    1
  ),
  FoodItem(
    "Spicy Chicken Wings",
    "Chef Alex",
    "Crispy and spicy chicken wings, perfect for sharing with friends.",
    R.drawable.spicy_chicken_wings,
    10.99,
    FoodType.Appetizer,
    500,
    8
  ),
  FoodItem(
    "Iced Caramel Latte",
    "Chef Olivia",
    "Refreshing iced latte with caramel flavor, a delightful pick-me-up.",
    R.drawable.iced_caramel_latte,
    4.99,
    FoodType.Beverage,
    200,
    1
  ),
  FoodItem(
    "Guacamole and Chips",
    "Chef Diego",
    "Freshly made guacamole served with crispy tortilla chips.",
    R.drawable.guacamole_and_chips,
    7.99,
    FoodType.Snack,
    400,
    1
  ),
  FoodItem(
    "Fruit Salad",
    "Chef Sofia",
    "A healthy and delicious mix of seasonal fruits, a perfect light option.",
    R.drawable.fruit_salad,
    6.99,
    FoodType.Snack,
    150,
    1
  ),
  FoodItem(
    "Cheese Platter",
    "Chef Ethan",
    "An assortment of fine cheeses served with crackers and fruits.",
    R.drawable.cheese_platter,
    18.99,
    FoodType.Appetizer,
    700,
    1
  ),
  FoodItem(
    "Chocolate Chip Cookies",
    "Chef Ava",
    "Homemade chocolate chip cookies, a sweet treat for any occasion.",
    R.drawable.chocolate_chip_cookies,
    5.99,
    FoodType.Dessert,
    200,
    3
  )
)
