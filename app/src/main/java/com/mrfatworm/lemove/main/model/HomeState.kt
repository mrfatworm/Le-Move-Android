package com.mrfatworm.lemove.main.model

import com.mrfatworm.lemove.R

data class HomeState(
    val hasNotification: Boolean,
    val friends: List<FriendState>,
    val sportList: List<SportListGroupState>
)

data class FriendState(
    val id: Int, val imgId: Int? = null, val name: String, val enable: Boolean = true
)

data class SportListGroupState(
    val titleId: Int, val list: List<SportPlayListItemState>
)

data class SportPlayListItemState(
    val id: Int,
    val imgId: Int,
    val titleId: Int,
    val actionCount: Int? = null,
    val min: String? = null,
    val sec: String? = null
)

val sampleHomeState = HomeState(
    hasNotification = true, friends = listOf(
        FriendState(0, R.drawable.img_avatar_pj, "PJ"),
        FriendState(1, R.drawable.img_avatar_lance, "Lance"),
        FriendState(2, R.drawable.img_avatar_cytpress, "Cytpress"),
        FriendState(3, R.drawable.img_avatar_meliy, "Miley"),
        FriendState(4, R.drawable.img_avatar_miliy, "Milly", enable = false),
        FriendState(id = 5, name = "小明")
    ), sportList = listOf(
        SportListGroupState(
            titleId = R.string.sport_group_title_01, list = listOf(
                SportPlayListItemState(
                    id = 0,
                    imgId = R.drawable.img_sport_playlist_01,
                    titleId = R.string.sport_playlist_title_01,
                    actionCount = 2,
                    min = "00",
                    sec = "20"
                ),
                SportPlayListItemState(
                    id = 1,
                    imgId = R.drawable.img_sport_playlist_02,
                    titleId = R.string.sport_playlist_title_02,
                    actionCount = 2,
                    min = "00",
                    sec = "50"
                ),
                SportPlayListItemState(
                    id = 2,
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