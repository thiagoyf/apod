package com.thiagoyf.core_data.model

import com.thiagoyf.core_model.data.Apod
import com.thiagoyf.core_network.model.NetworkApod
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun NetworkApod.asModel(): Apod {
    val format = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
    val localDate = LocalDate.parse(date)
    val formattedDate = localDate.format(format)

    val copyrightFormat = "\u00a9 $copyright"

    return Apod(
        copyright = copyrightFormat,
        date = formattedDate,
        explanation = explanation,
        hdurl = hdurl,
        mediaType = mediaType,
        serviceVersion = serviceVersion,
        title = title,
        url = url,
    )
}