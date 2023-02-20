package com.guru.graphqlapp.domain

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute():List<CountryInfo>{
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}