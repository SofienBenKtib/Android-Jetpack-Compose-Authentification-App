package com.example.authentification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authentification.ui.theme.AuthentificationTheme
import com.example.authentification.view.LoginPage
import com.example.authentification.view.ResetPassword
import com.example.authentification.view.Signup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthentificationTheme {
                NavigatePage()
            }
        }
    }
}

@Composable
fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login",
        builder = {
            composable("login", content = { LoginPage(navController = navController)})
            composable("register", content = { Signup(navController = navController) })
            composable("resetpassword", content = { ResetPassword(navController=navController)})
        }
    )
}