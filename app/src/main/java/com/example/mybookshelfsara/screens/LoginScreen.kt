package com.example.mybookshelfsara.screens
import androidx.compose.material3.Icon
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.davant.colorguesser.R
import kotlin.system.exitProcess


@Composable
fun LoginScreen(){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Red),
            contentAlignment = Alignment.TopEnd
        ){
            Header()
            Logo(Modifier.align(Alignment.Center))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Green)

        ){
            Body()
            Footer()
        }


    }
}

@Composable
fun Footer() {

}

@Composable
fun Body() {
Column(
   modifier = Modifier.fillMaxWidth()

) {
    Username()
    Password()
    Row(modifier = Modifier.fillMaxWidth()) {
        RegisterButton()
        LoginButton()
    }
    SocialButton()
}
}


@Composable
fun Header(){
    IconButton(
        modifier = Modifier.padding(24.dp),
        onClick = {
            exitProcess(0)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close app")
    }


}


@Composable

fun Logo(modifier: Modifier){
    Image(painter = painterResource(R.drawable.bookshelf_logo),
        contentDescription = "Aplication Logo")

}