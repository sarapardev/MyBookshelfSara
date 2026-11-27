package com.example.mybookshelfsara.screens

import com.example.mybookshelfsara.screens.UserName
import androidx.compose.material3.Icon
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mybookshelfsara.R
import kotlin.system.exitProcess


@Composable
fun Header() {
    IconButton(
        modifier = Modifier.padding(16.dp),
        onClick = {
            exitProcess(0)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close app"
        )
    }
}


@Composable

fun Logo(modifier: Modifier
){
    Image(
        painter = painterResource(R.drawable.bookshelf_logo),
        contentDescription = "Application Logo",
        modifier = modifier
    )
}


@Composable
fun LoginScreen(goToLogin: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold {innerPadding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Header()
                    Spacer(Modifier.padding(10.dp))
                    Logo(modifier = Modifier.align(Alignment.Center))
                    Text("")
                }

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Body(goToLogin)
                    Footer(Modifier.align(Alignment.BottomCenter))
                }
            }
        }
    }
}





@Composable
fun Body(goToLogin: (String) -> Unit) {
    var userName by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserName(userName) { userName = it }
        Password()
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            RegisterButton()
            LoginButton(userName, goToLogin)
        }
        HorizontalDivider(modifier = Modifier
            .padding(18.dp),
            thickness = 1.dp
        )
        SocialLogin()
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Text(modifier = modifier.padding(bottom = 16.dp),
        text =  "MyBookShelf Sara v1")
}

