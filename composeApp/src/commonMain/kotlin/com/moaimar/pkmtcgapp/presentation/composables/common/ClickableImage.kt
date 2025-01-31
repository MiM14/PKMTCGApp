package com.moaimar.pkmtcgapp.presentation.composables.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ClickableImage(imageUrl: String, contentDescription: String) {
    var showDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.clickable { showDialog = true }) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3 / 4f)
        )
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Close")
                }
            },
            text = {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .fillMaxSize()
                        .size(300.dp)
                )
            }
        )
    }
}