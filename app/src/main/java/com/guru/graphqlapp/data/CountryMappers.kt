package com.guru.graphqlapp.data

import com.guru.CountriesQuery
import com.guru.CountryQuery
import com.guru.graphqlapp.domain.CountryInfo
import com.guru.graphqlapp.domain.DetailedCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name

    )
}

fun CountriesQuery.Country.toCountryInfo(): CountryInfo {
    return CountryInfo(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital"
    )
}