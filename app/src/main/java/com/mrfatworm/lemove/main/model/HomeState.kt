package com.mrfatworm.lemove.main.model

import com.mrfatworm.lemove.R

data class HomeState(
    val hasNotification: Boolean,
    val friends: List<FriendState>,
    val sportList: List<SportListGroupState>
)

data class FriendState(
    val imgId: Int? = null, val name: String, val enable: Boolean = true
)

data class SportListGroupState(
    val titleId: Int, val list: List<SportPlayListItemState>
)

data class SportPlayListItemState(
    val imgId: Int,
    val titleId: Int,
    val actionCount: Int? = null,
    val min: String? = null,
    val sec: String? = null
)

val sampleHomeState = HomeState(
    hasNotification = true, friends = listOf(
        FriendState(R.drawable.img_avatar_pj, "PJ"),
        FriendState(R.drawable.img_avatar_lance, "Lance"),
        FriendState(R.drawable.img_avatar_cytpress, "Cytpress"),
        FriendState(R.drawable.img_avatar_meliy, "Miley"),
        FriendState(R.drawable.img_avatar_miliy, "Milly", enable = false),
        FriendState(name = "小明")
    ), sportList = listOf(
        SportListGroupState(
            titleId = R.string.sport_group_title_01, list = listOf(
                SportPlayListItemState(
                    imgId = R.drawable.img_sport_playlist_01,
                    titleId = R.string.sport_playlist_title_01,
                    actionCount = 2,
                    min = "00",
                    sec = "20"
                ),
                SportPlayListItemState(
                    imgId = R.drawable.img_sport_playlist_02,
                    titleId = R.string.sport_playlist_title_02,
                    actionCount = 2,
                    min = "00",
                    sec = "50"
                ),
                SportPlayListItemState(
                    imgId = R.drawable.img_sport_playlist_03,
                    titleId = R.string.sport_playlist_title_03,
                    actionCount = 2,
                    min = "00",
                    sec = "40"
                ),
            )
        )
    )
)