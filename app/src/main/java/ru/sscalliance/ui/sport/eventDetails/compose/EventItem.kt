package ru.sscalliance.ui.sport.eventDetails.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.unit.dp

@Composable
fun EventItem(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(text = title)
            Text(text = title)
        }
    }
}