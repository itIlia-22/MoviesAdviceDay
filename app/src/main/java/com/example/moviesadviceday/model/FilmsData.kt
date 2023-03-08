package com.example.moviesadviceday.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.moviesadviceday.R

data class FilmsData(
    @DrawableRes val imageFilms: Int,
    @StringRes val titleFilms: Int?,
    @StringRes val descFilms: Int?,

    )

val filmsInfo = listOf<FilmsData>(
    FilmsData(R.drawable.the_avengers_one, R.string.ave1, R.string.ave1desc),
    FilmsData(R.drawable.aver_two, R.string.ave2, R.string.ave2desc),
    FilmsData(R.drawable.aveg_three, R.string.ave3, R.string.ave3desc),
    FilmsData(R.drawable.aveg_foo, R.string.ave4, R.string.ave4desc),
    FilmsData(R.drawable.spaderman_one, R.string.sp1, R.string.sp2desc),
    FilmsData(R.drawable.spaderman_two, R.string.sp2, R.string.sp1desc),
    FilmsData(R.drawable.iron_one, R.string.iron1, R.string.iron1desc),
    FilmsData(R.drawable.iron_two, R.string.iron2, R.string.iron2desc),
    FilmsData(R.drawable.iron_three, R.string.iron3, R.string.iron3desc),
    FilmsData(R.drawable.sw_one, R.string.sw1, R.string.ave1desc),
    FilmsData(R.drawable.sw_two, R.string.sw2, R.string.sw2desc),
    FilmsData(R.drawable.sw_three, R.string.sw3, R.string.sw3desc),
    FilmsData(R.drawable.sw_foo, R.string.sw4, R.string.sw4desc),
    FilmsData(R.drawable.sw_fave, R.string.sw5, R.string.sw5desc),
    FilmsData(R.drawable.sw_six, R.string.sw6, R.string.sw6desc),


    )