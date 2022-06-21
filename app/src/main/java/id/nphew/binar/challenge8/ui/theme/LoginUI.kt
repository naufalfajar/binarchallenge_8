package id.nphew.binar.challenge8.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LoginScreen(){
    Column(verticalArrangement = Arrangement.spacedBy(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(100.dp))
        LoginTitle()
        RegisterIcon()
        Spacer(modifier = Modifier.height(20.dp))
        LoginInputField()
        Spacer(Modifier.height(50.dp))
        LoginButton()
    }
}

@Composable
fun LoginTitle(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()) {
        Text(text = "Login", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LoginInputField(){
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            LoginEmailTextField(label = "Email")
            LoginPasswordTextField(label = "Password")
        }
    }
}

@Composable
fun LoginEmailTextField(label: String) {
    var email by rememberSaveable { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = {email = it},
        label = { Text(label) },
        placeholder = { Text("Enter $label") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(all = 5.dp)
            .width(300.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
    )
}

@Composable
fun LoginPasswordTextField(label: String) {
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(label) },
        placeholder = { Text("Enter $label") },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = {
                showPassword = !showPassword
            }) {
                Icon(imageVector  = if (showPassword)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff, "")
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(all = 5.dp)
            .width(300.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
    )
}

@Composable
fun LoginButton(){
    Row {
       Column(verticalArrangement = Arrangement.spacedBy(10.dp),
       horizontalAlignment = Alignment.CenterHorizontally) {
           Button(
               onClick = { /*TODO*/ },
               colors = ButtonDefaults.buttonColors(
                   backgroundColor = binarColor,
                   contentColor = Color.White),
               modifier = Modifier
                   .width(300.dp)
           ) {
               Text(text = "Login")
           }
           NoAccount()
       }
    }
}

@Composable
fun NoAccount(){
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Belum Punya Akun?",
            fontSize = 12.sp,
            color = binarColor)
    }
}