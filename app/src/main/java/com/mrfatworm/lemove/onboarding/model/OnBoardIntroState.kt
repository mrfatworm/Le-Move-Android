package com.mrfatworm.lemove.onboarding.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mrfatworm.lemove.R

data class OnBoardIntroState(
    val infoPagers: List<InfoPager>
)

data class InfoPager(
    @DrawableRes val imageId: Int, @StringRes val titleId: Int, @StringRes val descriptionId: Int
)

val sampleOnboardIntroState = OnBoardIntroState(
    listOf(
        InfoPager(
            R.drawable.img_onboarding_01, R.string.onboard_intro_title1, R.string.onboard_intro_desc1
        ),
        InfoPager(
            R.drawable.img_onboarding_02, R.string.onboard_intro_title2, R.string.onboard_intro_desc2
        ),
        InfoPager(
            R.drawable.img_onboarding_03, R.string.onboard_intro_title3, R.string.onboard_intro_desc3
        )
    )
)

val sampleOnboardIntro2State = InfoPager(R.drawable.img_onboarding_04, R.string.onboard_intro_title4, R.string.onboard_intro_desc4)

val sampleOnboardIntro3State = InfoPager(R.drawable.img_onboarding_05, R.string.onboard_intro_title5, R.string.onboard_intro_desc5)