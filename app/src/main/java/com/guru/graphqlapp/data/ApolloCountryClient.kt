package com.guru.graphqlapp.data

import com.apollographql.apollo3.ApolloClient
import com.guru.CountriesQuery
import com.guru.CountryQuery
import com.guru.graphqlapp.domain.CountryClient
import com.guru.graphqlapp.domain.CountryInfo
import com.guru.graphqlapp.domain.DetailedCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<CountryInfo> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toCountryInfo() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}