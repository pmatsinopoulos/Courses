package com.mixlr.panos.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mixlr.panos.courses.data.TopicsDataSource
import com.mixlr.panos.courses.model.Topic
import com.mixlr.panos.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Courses()
                }
            }
        }
    }
}

@Composable
fun Courses(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        items(TopicsDataSource.topics) { topic ->
            Topic(topic)
        }
    }
}

@Composable
fun Topic(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.image),
                    contentDescription = stringResource(topic.name),
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.gray))
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp, bottom = 8.dp, start = 16.dp)
                ) {
                    Text(
                        text = stringResource(topic.name),
                        fontSize = 12.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_number_of_associated_courses
                        ),
                        contentDescription = stringResource(R.string.number_of_associated_courses),
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = topic.numberOfAssociatedCourses.toString(),
                        modifier = Modifier
                            .padding(start = 8.dp),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        Courses()
    }
}
