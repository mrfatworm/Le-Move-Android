package com.mrfatworm.lemove.onboarding.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mrfatworm.lemove.R

data class ChooseStyleState(
    val styleList: List<StyleItemState>
)

data class StyleItemState(
    @DrawableRes val imageId: Int,
    @StringRes val titleId: Int,
    @StringRes val descriptionId: Int = R.string.style_desc,
    val isPopular: Boolean = false,
    val isSelected: Boolean = false
)

val sampleChooseStyleState = ChooseStyleState(
    listOf(
        StyleItemState(
            R.drawable.img_style_01, R.string.style_title1, isPopular = true
        ), StyleItemState(
            R.drawable.img_style_02, R.string.style_title2, isPopular = true
        ), StyleItemState(
            R.drawable.img_style_03, R.string.style_title3, isPopular = true
        ), StyleItemState(
            R.drawable.img_style_04, R.string.style_title4
        ), StyleItemState(
            R.drawable.img_style_05, R.string.style_title5
        )
    )
)