package com.mrfatworm.lemove.onboarding.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mrfatworm.lemove.R

data class OnBoardIntroState(
    val infoPagers: List<InfoPager>
)

data class InfoPager(
    @DrawableRes val imageId: Int, @StringRes val titleId: Int, @StringRes val descriptionId: Int
)

val stubOnboardIntroState = OnBoardIntroState(
    listOf(
        InfoPager(
            R.drawable.img_onboarding1, R.string.onboard_intro_title1, R.string.onboard_intro_desc1
        ),
        InfoPager(
            R.drawable.img_onboarding2, R.string.onboard_intro_title2, R.string.onboard_intro_desc2
        ),
        InfoPager(
            R.drawable.img_onboarding3, R.string.onboard_intro_title3, R.string.onboard_intro_desc3
        )
    )
)

val stubOnboardIntro2State = InfoPager(R.drawable.img_onboarding4, R.string.onboard_intro_title4, R.string.onboard_intro_desc4)

val stubOnboardIntro3State = InfoPager(R.drawable.img_onboarding5, R.string.onboard_intro_title5, R.string.onboard_intro_desc5)