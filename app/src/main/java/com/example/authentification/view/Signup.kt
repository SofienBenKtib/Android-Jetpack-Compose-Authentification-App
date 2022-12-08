package com.example.authentification.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.authentification.R
import com.example.authentification.ui.theme.Purple500

@Composable
fun Signup(navController: NavController){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameVal = remember { mutableStateOf("") }
    val emailVal = remember { mutableStateOf("") }
    val phoneVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val confirmPasswordVal = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
                    ){
                Image(
                    painter = painterResource(id = com.example.authentification.R.drawable.signup),
                    contentDescription = "Sign up image",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp),
                    contentScale = ContentScale.Fit
                )
            }
            //Spacer(modifier = Modifier.padding(20.dp))
            Scaffold (
                modifier = Modifier
                    .fillMaxSize(),
                    scaffoldState = scaffoldState,
                    ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.White)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                        )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        //*** NAME ***
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = {nameVal.value=it},
                            label = { Text(text = "Name")},
                            placeholder = { Text(text = "Name", color= Color.DarkGray)},
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedLabelColor = colorResource(id = R.color.purple_500),
                                unfocusedBorderColor = Color.Black
                            )
                            )

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

                        //*** Phone ***
                        OutlinedTextField(
                            value = phoneVal.value,
                            onValueChange = {phoneVal.value=it},
                            label = { Text(text = "Phone number")},
                            placeholder = { Text(text = "Phone number", color= Color.DarkGray)},
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedLabelColor = colorResource(id = R.color.purple_500),
                                unfocusedBorderColor = Color.Black
                            ),
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
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

                        //*** CONFIRM PASSWORD ***
                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
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
                                text = "Confirm Password",
                                color = Color.Black
                            )},
                            placeholder = { Text(
                                text = "Confirm Password",
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

                                confirmPasswordVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context,"Please enter your password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                phoneVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context,"Please enter your password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                nameVal.value.isEmpty() -> {
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
                            Text(text = "Register", fontSize = 23.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Text(text = "You already have an account ? Log In", modifier = Modifier
                            .clickable { navController.navigate("login") })
                    }
                }
            }
        }
    }

}