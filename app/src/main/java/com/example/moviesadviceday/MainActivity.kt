package com.example.moviesadviceday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesadviceday.model.FilmsData
import com.example.moviesadviceday.model.filmsInfo
import com.example.moviesadviceday.ui.theme.MoviesAdviceDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAdviceDayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListFilms()
                }
            }
        }
    }
}

@Composable
fun ListFilms() {
    LazyColumn() {
        items(filmsInfo) {
            CardFilm(film = it)
        }
    }
}


/**
 * Функция карточки
 * @param film data. Данные и их описание
 * @param Обычный модификатор
 */
@Composable
fun CardFilm(film: FilmsData, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .sizeIn(minHeight = 50.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(film.imageFilms),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 200.dp, height = 200.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 100.dp)
                ) {
                    Text(text = stringResource(film.titleFilms!!))
                    IconDescription(
                        expanded = expanded,
                        onClick = { expanded = !expanded }
                    )
                    if (expanded) {
                        DescriptionFilms(film.descFilms!!)

                    }

                }
            }
        }


    }

}

/**
 * Функция описания фильма
 */
@Composable
fun DescriptionFilms(@StringRes desc: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(text = stringResource(R.string.desc))
        Text(text = stringResource(desc))
    }

}

/**
 * Функция иконки(Раскрытие описание)
 * @param expanded состояние иконки
 * @param onClick нажатие на иконку
 */
@Composable
private fun IconDescription(
    expanded: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesAdviceDayTheme {
        CardFilm(film = FilmsData(R.drawable.spaderman_two, R.string.sp2, null))
    }
}