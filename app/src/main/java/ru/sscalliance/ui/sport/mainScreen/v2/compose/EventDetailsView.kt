package ru.sscalliance.ui.sport.mainScreen.v2.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ru.sscalliance.R
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.ui.compose.theme.SSCAllianceTheme
import ru.sscalliance.utils.Navigator

class EventDetailsView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<EventBusinessModel>(Navigator.EVENT_DETAILS)

        setContent {
            SSCAllianceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    item?.let { EventDetailsView(it) }
                }
            }
        }
    }
}

@Composable
internal fun EventDetailsView(
    event: EventBusinessModel,
) {
    EventDetailsView(
        title = event.title,
        image = event.image,
        publicationDate = event.publicationDate,
    )
}

@Composable
fun EventDetailsView(
    title: String,
    image: String,
    publicationDate: String,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            elevation = 4.dp,
            backgroundColor = Color.Gray,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(216.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = image,
                    error = painterResource(id = R.drawable.photo_test_1)
                ),
                contentScale = ContentScale.FillBounds,
                contentDescription = "",
            )
        }
        Text(
            text = stringResource(id = R.string.informations),
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp),
        )
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp),
        )
        Text(
            text = stringResource(id = R.string.show_all),
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp),
        )

        Text(
            text = stringResource(id = R.string.tv_date_organizing),
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        )
        Text(
            text = publicationDate,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp),
        )

        Text(
            text = stringResource(id = R.string.tv_address),
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        )
        Text(
            text = "Адрес",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp),
        )

        // todo socials
        Row {
            //Icon(painter =, contentDescription = "")
        }

        Text(
            text = stringResource(id = R.string.organizers),
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        )
        //LazyRow(content =)
        Text(
            text = stringResource(id = R.string.photos),
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        )
        //
        Text(
            text = stringResource(id = R.string.documents),
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SSCAllianceTheme {
        //EventDetailsView("Android")
    }
}