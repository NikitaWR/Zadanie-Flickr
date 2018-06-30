package pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed

import pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.response.PublicFeedItemJsonResponse
import java.text.DateFormat
import java.text.ParseException
import java.util.Date

/**
 * Created by Michal S. on 05.12.2017.
 * Converters for json data strings to final structure
 */
//TODO converters


fun PublicFeedItemJsonResponse.getPublishedDate(): Date? {
    val datePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val dateFormatter: DateFormat = java.text.SimpleDateFormat(datePattern, java.util.Locale.getDefault())
    published?.let {
        return try {
            dateFormatter.parse(it)
        } catch (e: ParseException) {
            null
        }
    }
    return null
}

fun PublicFeedItemJsonResponse.getTags(): List<String> {
    val tagsSeparator = " "
    return tags.split(tagsSeparator.toRegex()).dropLastWhile { it.isEmpty() }.toList()
}