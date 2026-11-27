package com.example.mybookshelfsara.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.mybookshelfsara.ui.theme.AzulPetroleo
import com.example.mybookshelfsara.ui.theme.RosaPastel
import com.example.mybookshelfsara.ui.theme.Sage
import com.example.mybookshelfsara.ui.theme.VerdeBosque

@Composable
fun HomeScreen(userName: String, onBack: () -> NavKey) {
    Scaffold {innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            Card(modifier = Modifier
                .width(300.dp)
                .height(125.dp),
                shape = RoundedCornerShape(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = VerdeBosque,
                    contentColor = Sage
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                border = BorderStroke(3.dp, AzulPetroleo)
            ) {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Bienvenido/a ${getNameCleared(userName)}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center

                    )
                }
            }
            Button(
                onClick = { onBack() },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(24.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Atrás"
                )
            }
        }
    }
}

fun getNameCleared(oldName: String): String {
    val listParts = oldName.split("@")
    return listParts[0]
}