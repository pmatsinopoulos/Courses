package com.mixlr.panos.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
    LazyColumn(

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
    Row(
        modifier = Modifier
            .wrapContentHeight(align = Alignment.Top)
            .background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.light_gray))
        ) {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = stringResource(topic.name),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
            )

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
                        fontSize = 36.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp)
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
                        fontSize = 20.sp
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
