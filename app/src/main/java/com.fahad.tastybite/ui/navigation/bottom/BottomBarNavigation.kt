package com.fahad.tastybite.ui.navigation.bottom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.fahad.tastybite.ui.screen.favorite.FavoriteViewModel


import com.fahad.tastybite.ui.navigation.Graph
import com.fahad.tastybite.ui.screen.Home
import com.fahad.tastybite.ui.screen.ItemDetailsScreen
import com.fahad.tastybite.ui.screen.SearchScreen

import com.fahad.tastybite.ui.screen.UserDataViewModel
import com.fahad.tastybite.ui.screen.auth.profile.EditProfileScreen
import com.fahad.tastybite.ui.screen.auth.profile.ProfileScreen
import com.fahad.tastybite.ui.screen.cart.CartScreen
import com.fahad.tastybite.ui.screen.cart.CartViewModel
import com.fahad.tastybite.ui.screen.favorite.FavoriteItemsScreen

@Composable
fun BottomBarNavigation(navController: NavHostController,
) {
  val userDataViewModel: UserDataViewModel = hiltViewModel()
  val viewModel: CartViewModel = hiltViewModel()
  val favoriteViewModel: FavoriteViewModel = hiltViewModel()
  LaunchedEffect(userDataViewModel.user) {
    userDataViewModel.getUserData() // Trigger fetching user data if not already done

  }




  NavHost(
    navController = navController,
    route = Graph.HOME,
    startDestination = BottomBar.Home.route
  ) {
    composable(route = BottomBar.Home.route) {
      Home(viewModel, navController,userDataViewModel)
    }

    composable(route = BottomBar.Cart.route) {
      CartScreen(viewModel)
    }

    composable(route = BottomBar.Favorite.route) {
      FavoriteItemsScreen(favoriteViewModel, navController)

    }


    composable(route = BottomBar.Profile.route) {
      ProfileScreen(
        navController = navController,
        userDataViewModel = userDataViewModel
      )
    }
      composable(route =  "edit_profile") {
        EditProfileScreen(
          navController = navController, userDataViewModel = userDataViewModel
        )
      }

    composable(
      "itemDetails/{itemName}",
      arguments = listOf(navArgument("itemName") { type = NavType.StringType })
    ) { backStackEntry ->
      val itemName = backStackEntry.arguments?.getString("itemName")
      val selectedItem = viewModel.groupedItems.values.flatten()
          .firstOrNull { it.name == itemName }
      selectedItem?.let { item ->
        ItemDetailsScreen(item, viewModel, favoriteViewModel, navController)
      } ?: run {
        Text(text = "Item not found")
      }
    }




    searchNavGraph(navController = navController)
  }
}

fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {

  navigation(
    route = Graph.Search,
    startDestination = SearchNavGraph.Search.route
  ) {
    composable(route = SearchNavGraph.Search.route) {
        SearchScreen(navController = navController, viewModel = hiltViewModel())



    }

    }
  }


sealed class SearchNavGraph(val route: String) {
  data object Search : SearchNavGraph(route = "Search")

}


