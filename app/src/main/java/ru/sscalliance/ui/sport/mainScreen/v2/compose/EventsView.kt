package ru.sscalliance.ui.sport.mainScreen.v2.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.ui.compose.theme.SSCAllianceTheme
import ru.sscalliance.ui.sport.mainScreen.v2.viewModel.MainScreenViewModel

@AndroidEntryPoint
internal class EventsView : ComponentActivity() {

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSCAllianceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EventsListView(viewModel)
                }
            }
        }
    }
}

@Composable
internal fun EventsListView(
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(items = viewModel.eventsDelegate.events) { item ->
            EventItemView(
                item,
                viewModel.eventsDelegate::onEventClicked,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun DefaultPreview() {
    SSCAllianceTheme {
        EventsListView()
    }
}