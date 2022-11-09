package com.example.uiplayground.presentation.FitnessTracker.util

import com.example.uiplayground.R

sealed class Tracker(
    val value: String,
    val type: String,
    val icon: Int,
    val progress: Float
) {
    object Steps : Tracker(
        value = "3212",
        type = "steps",
        icon = R.drawable.kilometers,
        progress = 0.55f
    )

    object Kilometers : Tracker(
        value = "3.5",
        type = "km",
        icon = R.drawable.location,
        progress = 0.45f
    )

    object Time : Tracker(
        value = "35",
        type = "minutes",
        icon = R.drawable.strength,
        progress = 0.3f
    )
}
