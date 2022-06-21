package id.nphew.binar.challenge8.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.nphew.binar.challenge8.R

@Preview(showBackground = true)
@Composable
fun RegisterScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(100.dp))
        RegisterTitle()
        RegisterIcon()
        Spacer(modifier = Modifier.height(20.dp))
        RegisterInputField()
        Spacer(modifier = Modifier.height(50.dp))
        RegisterButton()
    }
}


@Composable
fun RegisterTitle(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()) {
        Text(text = "Register", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun RegisterIcon(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        RoundedImage(
            image = painterResource(id = R.drawable.binarlogo),
            contentDesc = "binarlogo",
            modifier = Modifier.size(100.dp))
    }
}

@Composable
fun RoundedImage(
    image: Painter,
    contentDesc: String,
    modifier: Modifier = Modifier

) {
    Image(
        painter = image,
        contentDescription = contentDesc,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(RoundedCornerShape(10.dp)))
}

@Composable
fun RegisterInputField(){
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
            RegisterEmailTextField(label = "Username")
            RegisterEmailTextField(label = "Email")
            RegisterPasswordTextField(label = "Password")
            RegisterPasswordTextField(label = "Confirmation Password")

        }
    }
}

@Composable
fun RegisterEmailTextField(label: String) {
    var email by rememberSaveable { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = {email = it},
        label = {Text(label)},
        placeholder = {Text("Enter $label")},
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
fun RegisterPasswordTextField(label: String) {
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
fun RegisterButton(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = binarColor,
            contentColor = Color.White),
        modifier = Modifier
            .width(300.dp)
    ) {
        Text(text = "Register")
    }
}