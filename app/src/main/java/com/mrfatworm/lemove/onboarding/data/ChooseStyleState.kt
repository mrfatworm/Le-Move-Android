package com.mrfatworm.lemove.onboarding.data

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

val stubChooseStyleState = ChooseStyleState(
    listOf(
        StyleItemState(
            R.drawable.style1, R.string.style_title1, isPopular = true
        ), StyleItemState(
            R.drawable.style2, R.string.style_title2, isPopular = true
        ), StyleItemState(
            R.drawable.style3, R.string.style_title3, isPopular = true
        ), StyleItemState(
            R.drawable.style4, R.string.style_title4
        ), StyleItemState(
            R.drawable.style5, R.string.style_title5
        )
    )
)