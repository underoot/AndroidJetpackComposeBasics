package dev.underoot.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameId: Int,
    val count: Int,
    @DrawableRes val imageId: Int
)
