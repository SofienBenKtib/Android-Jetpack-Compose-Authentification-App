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
fun ResetPassword(navController: NavController){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal= remember { mutableStateOf("") }

    Box(modifier =
    Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

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
                        text = "Reset your password",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.padding(20.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {

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

                        Spacer(modifier = Modifier.padding(20.dp))

                        //*** BUTTON ***
                        Button(
                            onClick = { when{
                                emailVal.value.isEmpty() -> {
                                    Toast.makeText(
                                        context,"Please enter your email adress",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    Toast.makeText(
                                        context,"Check your email for a verification message",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } },
                            colors = ButtonDefaults.buttonColors(Color.DarkGray),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Reset", fontSize = 23.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                    }
                }
            }
        }
    }
}