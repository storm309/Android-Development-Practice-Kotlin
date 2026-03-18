package com.example.cse_unit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cse_unit1.ui.theme.CSE_UNIt1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSE_UNIt1Theme {
//                SimpleScrollExample()
//                NestedScrollExample()
//                GridExample()
//                SpinnerExample()
//                RatingApp()
                MenuApp()
            }
        }
    }
}

@Composable
fun SimpleScrollExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        repeat(25) {
            Text(
                text = "Scrollable Item ${it + 1}",
                fontSize = 26.sp,
                color = Color.Blue,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun NestedScrollExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Header Section",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .height(300.dp)
                .padding(horizontal = 16.dp)
        ) {
            items(20) { index ->
                Text(
                    text = "Lazy Column Item ${index + 1}",
                    fontSize = 26.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Text(
            text = "Footer Section (Horizontal Scroll)",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
        ) {
            items(20) { index ->
                Text(
                    text = "Row Item ${index + 1}",
                    fontSize = 26.sp,
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun GridExample() {
    val subjects = listOf("Python", "C,Html,Css and Js", "CPP AND DSA", "Java and advance js", "Kotlin and React Native",
        "Android & database", "SpringBoot", "Project")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Sem Sub",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .height(400.dp)
                .padding(8.dp)
        ) {
            itemsIndexed(subjects) { index, subject ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(110.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Sem ${index + 1}",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = subject,
                                fontSize = 22.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SpinnerExample() {
    val items = listOf("CSE", "ECE", "IT", "MECH", "CIVIL")

    val colors = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Gray
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(items[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box {
            OutlinedTextField(
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select Dept") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "DropDown"
                        )
                    }
                }
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { expanded = !expanded }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                items.forEachIndexed { index, label ->
                    DropdownMenuItem(
                        text = {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = colors[index % colors.size]
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = label,
                                        fontSize = 18.sp,
                                        color = Color.Black
                                    )
                                }
                            }
                        },
                        onClick = {
                            selectedItem = label
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RatingApp() {
    var rating by remember { mutableStateOf(0.0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rate this App:",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomRatingBar(
            rating = rating,
            onRatingChanged = {
                rating = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Rating: $rating",
            fontSize = 18.sp
        )
    }
}

@Composable
fun CustomRatingBar(
    maxRating: Int = 5,
    rating: Double,
    onRatingChanged: (Double) -> Unit,
) {
    Row {
        for (i in 1..maxRating) {
            val starRating = i.toDouble()
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .pointerInput(i) {
                        detectTapGestures { offset ->
                            val isHalf = offset.x < size.width / 2
                            val newRating = if (isHalf) starRating - 0.5 else starRating
                            onRatingChanged(newRating)
                        }
                    }
            ) {
                // Background: Gray Star
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Gray
                )

                // Foreground: Yellow Star (Clipped based on rating)
                val fillFraction = when {
                    rating >= starRating -> 1.0f
                    rating >= starRating - 0.5 -> 0.5f
                    else -> 0.0f
                }

                if (fillFraction > 0f) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fillFraction)
                            .fillMaxHeight()
                            .clipToBounds()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = Color.Yellow
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuApp() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("None") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menu Example") },
                actions = {
                    Box {
                        IconButton(onClick = { expanded = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Menu"
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Setting") },
                                onClick = {
                                    selectedItem = "Setting"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("About") },
                                onClick = {
                                    selectedItem = "About"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("LogOut") },
                                onClick = {
                                    selectedItem = "LogOut"
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Selected Menu Item: $selectedItem",
                fontSize = 24.sp,
                color = Color.Blue
            )
        }
    }
}
