package com.example.framgianguyenvulan.kotlinbeginning

import com.example.framgianguyenvulan.kotlinbeginning.data.db.ForecastProvider
import com.example.framgianguyenvulan.kotlinbeginning.domain.datasource.ForecastDataSource
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.Forecast
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.ForecastList
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Created by FRAMGIA\nguyen.vu.lan on 10/24/17.
 */
class ForecastProviderTest {

    @Test
    fun testDataSourceReturnValue() {
        val ds = mock(ForecastDataSource::class.java)
        `when`(ds.requestDayForecast(0)).then {
            Forecast(0, 0, "desc", 20, 0, "url")
        }
        val provider = ForecastProvider(listOf(ds))
        assertNotNull(provider.requestForecast(0))
    }

    @Test
    fun emptyDatabaseReturnServervalue() {
        val db = mock(ForecastDataSource::class.java)
        val server = mock(ForecastDataSource::class.java)
        `when`(server.requestForecastByZipcode(any(Long::class.java), any(Long::class.java)))
                .then {
                    ForecastList(0, "city", "country", listOf())
                }
        val provider = ForecastProvider(listOf(db, server))
        assertNotNull(provider.requestByZipCode(0,0))
    }

}