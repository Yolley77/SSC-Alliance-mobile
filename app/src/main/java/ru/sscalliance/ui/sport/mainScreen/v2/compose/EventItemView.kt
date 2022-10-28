package ru.sscalliance.ui.sport.mainScreen.v2.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ru.sscalliance.R
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel

@Composable
internal fun EventItemView(
    event: EventBusinessModel,
    onClick: (EventBusinessModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    EventItemView(
        date = event.publicationDate,
        title = event.title,
        image = event.image,
        onClick = { onClick.invoke(event) },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun EventItemView(
    date: String,
    title: String,
    image: String,
    onClick: () -> Unit = {},
) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(216.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = image,
                error = painterResource(id = R.drawable.photo_test_1)
            ),
            contentScale = ContentScale.FillBounds,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = date,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                color = Color.Black,
                modifier = Modifier
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(6.dp)
            )
            Text(
                text = title,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}