package com.example.framgianguyenvulan.kotlinbeginning

import com.example.framgianguyenvulan.kotlinbeginning.data.db.ForecastProvider
import com.example.framgianguyenvulan.kotlinbeginning.domain.commands.RequestDayForecastCommand
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by FRAMGIA\nguyen.vu.lan on 10/24/17.
 */
class RequestDayForecastCommandTest {
    @Test
    fun testProviderIsCalled() {
        val forecastProvider = mock(ForecastProvider::class.java)
        val command = RequestDayForecastCommand(2, forecastProvider)
        command.execute()
        verify(forecastProvider).requestForecast(2)
    }
}