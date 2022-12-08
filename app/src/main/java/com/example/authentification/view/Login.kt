package com.example.authentification.view

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.authentification.R
import com.example.authentification.ui.theme.Purple500

@Composable
fun LoginPage(navController: NavController){
   val context = LocalContext.current
   val scaffoldState = rememberScaffoldState()
   val emailVal= remember { mutableStateOf("") }
   val passwordVal = remember { mutableStateOf("") }
   val passwordVisibility = remember { mutableStateOf(false) }

    Box(modifier =
    Modifier
        .fillMaxSize()
        .background(Color.White),
            contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            //image container
            Box(modifier = Modifier
                .background(Color.White),
                contentAlignment = Alignment.TopCenter) {
                Image(modifier = Modifier
                    .width(400.dp)
                    .height(350.dp),
                    painter = painterResource(id = com.example.authentification.R.drawable.login),
                    contentDescription="Login Image.",
                    contentScale = ContentScale.Fit)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Scaffold(modifier = Modifier
                .fillMaxSize(),
                scaffoldState=scaffoldState,) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    
                    Spacer(modifier = Modifier.padding(20.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        //*** EMAIL ***
                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = {emailVal.value=it},
                            label = { Text(text = "Email") },
                            placeholder = { Text(text = "example@domaine.com", color = Color.DarkGray)},
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black, textColor = Color.Black, focusedBorderColor = colorResource(id = com.example.authentification.R.color.purple_500))
                        )

                        //*** PASSWORD ***
                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black, textColor = Color.Black, focusedBorderColor = colorResource(id = com.example.authentification.R.color.purple_500)
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = { passwordVisibility.value = !passwordVisibility.value })
                                {
                                 Icon(
                                     painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                                     contentDescription = "Toggle password",
                                     tint = if(passwordVisibility.value) Purple500 else Color.Gray
                                     )
                                }
                            },
                            label = { Text(
                                text = "Password",
                                color = Color.Black
                            )},
                            placeholder = { Text(
                                text = "Password",
                                color=Color.DarkGray
                            )},
                            singleLine = true,
                            visualTransformation = if (passwordVisibility.value)
                                VisualTransformation.None
                                    else
                                        PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        
                        Spacer(modifier = Modifier.padding(20.dp))

                        //*** BUTTON ***
                        Button(
                            onClick = { when{
                                emailVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context,"Please enter a valid email adress",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                passwordVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context,"Please enter your password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    Toast.makeText(
                                        context,"Logged in successfully, Welcome !",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } },
                            colors = ButtonDefaults.buttonColors(Color.DarkGray),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                            ) {
                            Text(text = "Sign In", fontSize = 23.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))
                        
                        Text(text = "Create an account", modifier = Modifier
                            .clickable { navController.navigate("register") })
                    }
                }
            }
        }
    }
}