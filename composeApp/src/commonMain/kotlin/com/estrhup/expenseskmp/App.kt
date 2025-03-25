package com.estrhup.expenseskmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import expenseskmp.composeapp.generated.resources.Res
import expenseskmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val colors = getColorsTheme()

        AppTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                Text("Prueba 1")
                Text("Prueba 2")
                Text("Prueba 3")
                Text("Prueba 4")
            }
        }
    }
}
