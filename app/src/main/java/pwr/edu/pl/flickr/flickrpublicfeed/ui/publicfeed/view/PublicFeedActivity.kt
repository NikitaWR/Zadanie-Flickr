package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.view

import android.app.ActionBar
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewCompat.setNestedScrollingEnabled
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed.PublicFeedData
import pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.viewmodel.PublicFeedListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_public_feed.*
import pwr.edu.pl.flickr.R
import pwr.edu.pl.flickr.databinding.ActivityPublicFeedBinding
import android.widget.AbsListView



class PublicFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        val publicFeedViewModel = ViewModelProviders.of(this).get(PublicFeedListViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityPublicFeedBinding>(this, R.layout.activity_public_feed)
        binding.listViewModel = publicFeedViewModel

        val dataSource  = PublicFeedData()
        dataSource.loadDataForTest()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null) {
                        Log.d("ELEMENTS", "Size of data ${it.size}")
                    }
                }, {
    })


        supportActionBar?.setTitle(null)
        supportActionBar?.setSubtitle(null)
        // Toast.makeText(this, "no action bar", Toast.LENGTH_SHORT)
        val imageView = ImageView(this)

        imageView.setImageResource(R.drawable.flickimg)

        supportActionBar?.setCustomView(imageView)
        supportActionBar?.setDisplayShowCustomEnabled(true)




    }


}
