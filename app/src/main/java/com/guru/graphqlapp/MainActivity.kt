package com.guru.graphqlapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.guru.graphqlapp.presentation.CountriesScreen
import com.guru.graphqlapp.presentation.CountriesViewModel
import com.guru.graphqlapp.ui.theme.GraphQlAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlAppTheme {
                val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()
                CountriesScreen(
                    state = state,
                    onSelectedCountry = viewModel::selectCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog)
            }
        }
    }
}
