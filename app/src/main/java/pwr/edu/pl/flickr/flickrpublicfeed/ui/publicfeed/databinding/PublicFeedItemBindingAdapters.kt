package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.databinding

import android.databinding.BindingAdapter
import android.support.annotation.VisibleForTesting
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Michal S. on 05.12.2017.
 * Bindings for Public Feed items on the list
 */
@BindingAdapter("publishedDateBind")
fun bindPublishedDate(textView: TextView, date: Date?) {
    if (date != null) {
        textView.text = SimpleDateFormat.getDateTimeInstance().format(date)
    }
}

@BindingAdapter("imageBind")
fun bindFlickrImage(imageView: ImageView, imageUrl: String) {
    Picasso.with(imageView.context).load(imageUrl).into(imageView)
}


@BindingAdapter("tagsBind")
fun bindTags(textView: TextView, tags: List<String>) {
    textView.text = max3tagsToString(tags)
}

@VisibleForTesting
fun max3tagsToString(tags: List<String>): String {
    val limit = 3
    val tagsStringBuilder = StringBuilder()
    tags.take(limit).forEach { tag ->
        tagsStringBuilder.append(tag)
        tagsStringBuilder.append(" ")
    }
    return tagsStringBuilder.toString()
}