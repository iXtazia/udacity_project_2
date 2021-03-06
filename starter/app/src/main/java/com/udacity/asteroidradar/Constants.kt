package com.udacity.asteroidradar

import com.udacity.asteroidradar.api.getNextSevenDaysFormattedDates

object Constants {
    const val API_QUERY_DATE_FORMAT = "YYYY-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7
    const val BASE_URL = "https://api.nasa.gov/"
    const val API_KEY = "NkpPtcc7eBuja9cZaXo2wVohpuygV69ZFlCgvc0o"
    val START_DATE = getNextSevenDaysFormattedDates()[0]
    val END_DATE = getNextSevenDaysFormattedDates()[7]
}