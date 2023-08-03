package com.mixlr.panos.courses.data

import com.mixlr.panos.courses.R
import com.mixlr.panos.courses.model.Topic

object TopicsDataSource {
    val topics: List<Topic> = listOf(
        Topic(
            image = R.drawable.architecture,
            name = R.string.architecture,
            numberOfAssociatedCourses = 58
        ),
        Topic(
            image = R.drawable.business,
            name = R.string.business,
            numberOfAssociatedCourses = 121
        ),
        Topic(
            image = R.drawable.crafts,
            name = R.string.crafts,
            numberOfAssociatedCourses = 78
        ),
        Topic(
            image = R.drawable.culinary,
            name = R.string.culinary,
            numberOfAssociatedCourses = 23
        ),
        Topic(
            image = R.drawable.design,
            name = R.string.design,
            numberOfAssociatedCourses = 42
        ),
        Topic(
            image = R.drawable.drawing,
            name = R.string.drawing,
            numberOfAssociatedCourses = 101
        ),
        Topic(
            image = R.drawable.fashion,
            name = R.string.fashion,
            numberOfAssociatedCourses = 33
        ),
        Topic(
            image = R.drawable.film,
            name = R.string.film,
            numberOfAssociatedCourses = 58
        ),
        Topic(
            image = R.drawable.gaming,
            name = R.string.gaming,
            numberOfAssociatedCourses = 29
        ),
        Topic(
            image = R.drawable.lifestyle,
            name = R.string.lifestyle,
            numberOfAssociatedCourses = 29
        ),
        Topic(
            image = R.drawable.music,
            name = R.string.music,
            numberOfAssociatedCourses = 29
        ),
        Topic(
            image = R.drawable.painting,
            name = R.string.painting,
            numberOfAssociatedCourses = 29
        ),
        Topic(
            image = R.drawable.photography,
            name = R.string.photography,
            numberOfAssociatedCourses = 29
        ),
        Topic(
            image = R.drawable.tech,
            name = R.string.tech,
            numberOfAssociatedCourses = 29
        )
    )
}
