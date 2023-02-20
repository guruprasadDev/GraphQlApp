package com.guru.graphqlapp.domain

interface CountryClient {
    suspend fun getCountries(): List<CountryInfo>
    suspend fun getCountry(code:String):DetailedCountry?
}