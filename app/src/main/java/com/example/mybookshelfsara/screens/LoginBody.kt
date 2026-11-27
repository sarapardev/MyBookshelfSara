package com.example.mybookshelfsara.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mybookshelfsara.R
import com.example.mybookshelfsara.ui.theme.AzulPetroleo
import com.example.mybookshelfsara.ui.theme.RosaPastel
import androidx.compose.ui.platform.LocalContext

@Composable
fun UserName(userName: String, onNameChange: (String) -> Unit) {
    TextField(
        value = userName,
        onValueChange = { onNameChange(it) },
        placeholder = {
            Text(
                text = "Username",
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
    )
}

@Composable
fun Password() {
    var password by rememberSaveable { mutableStateOf("") }
    var passVisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { password = it },
        placeholder = {
            Text(
                text = "Password",
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        },
        trailingIcon = {
            val eyeIcon = if(passVisibility) R.drawable.ojo_visible
            else R.drawable.ojo_oculto
            Icon(
                painter = painterResource(eyeIcon),
                contentDescription = if (passVisibility) "Contraseña visible"
                else "Contraseña oculta ",
                modifier = Modifier.clickable {
                    passVisibility = !passVisibility
                }
            )
        },
        visualTransformation = if (passVisibility) PasswordVisualTransformation()
       else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
    )
}



@Composable
fun RegisterButton() {
    Button(
        onClick = { /* Registrar nuevo usuario */ },
        modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors
                (containerColor = RosaPastel,
        contentColor = Color.White
    )
    ) {
        Text("Register")
    }
}

@Composable
fun LoginButton(userName: String, goToLogin: (String) -> Unit) {
    Button(
        onClick = {goToLogin(userName)},
        modifier = Modifier.width(100.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = AzulPetroleo,
        contentColor = Color.White
    )
    ) {
        Text("Login")
    }
}
@Composable
fun SocialLogin() {
    val context = LocalContext.current
    Row(modifier = Modifier
        .clickable {
            Toast.makeText(
                context,
                "NO IMPLEMENTADO",
                Toast.LENGTH_SHORT
            ).show()

        }
    ) {
        Image(
            painter = painterResource(
                id =R.drawable.google
            ),
            contentDescription = "Google logo",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Iniciar sesión con Google",
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

