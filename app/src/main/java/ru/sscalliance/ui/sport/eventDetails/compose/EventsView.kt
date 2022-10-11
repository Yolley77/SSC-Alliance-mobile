package ru.sscalliance.ui.sport.eventDetails.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sscalliance.ui.sport.eventDetails.compose.ui.theme.SSCAllianceTheme

class EventsView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSCAllianceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EventsListView(
                        listOf(
                            "Android ".repeat(5), "Hello", "Hi", "Word ".repeat(5),
                            "Android ".repeat(5), "Hello", "Hi", "Word ".repeat(5),
                            "Android ".repeat(5), "Hello", "Hi", "Word ".repeat(5),
                            "Android ".repeat(5), "Hello", "Hi", "Word ".repeat(5),
                            "Android ".repeat(5), "Hello", "Hi", "Word ".repeat(5),
                        ).shuffled()
                    )
                }
            }
        }
    }
}

@Composable
fun EventsListView(
    events: List<String>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(items = events) { item ->
            EventItem(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SSCAllianceTheme {
        EventsListView(listOf("Android"))
    }
}