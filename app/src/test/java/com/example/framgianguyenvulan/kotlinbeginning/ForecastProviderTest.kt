package com.example.framgianguyenvulan.kotlinbeginning

import com.example.framgianguyenvulan.kotlinbeginning.data.db.ForecastProvider
import com.example.framgianguyenvulan.kotlinbeginning.domain.datasource.ForecastDataSource
import com.example.framgianguyenvulan.kotlinbeginning.domain.model.Forecast
import org.junit.Assert.assertNotNull
import org.junit.Test
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


}