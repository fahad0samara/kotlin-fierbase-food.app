package com.fahad.tastybite.ui.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fahad.tastybite.ui.navigation.Graph
import com.fahad.tastybite.ui.screen.auth.login.LoginScreen
import com.fahad.tastybite.ui.screen.auth.register.RegisterScreen
import com.fahad.tastybite.ui.screen.auth.login.LoginViewModel
import com.fahad.tastybite.ui.screen.auth.register.RegisterViewModel

fun NavGraphBuilder.AuthNavigation(navController: NavHostController,
                                   loginViewModel: LoginViewModel,
                                   registerViewModel: RegisterViewModel
) {

  navigation(
    route = Graph.AUTHENTICATION,
    startDestination = AuthScreen.LOGIN.route
  )


  {

    composable(route = AuthScreen.LOGIN.route) {
      LoginScreen(
        navController = navController, loginViewModel = loginViewModel
      )
    }
    composable(route = AuthScreen.REGISTER.route) {
      RegisterScreen(
        navController = navController, registerViewModel = registerViewModel
      )
    }

  }
}

sealed class AuthScreen(val route: String) {
  data object LOGIN : AuthScreen(route = "LOGIN")
  data object REGISTER : AuthScreen(route = "REGISTER")

}

