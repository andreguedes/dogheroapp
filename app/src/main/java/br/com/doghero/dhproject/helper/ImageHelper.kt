package br.com.doghero.dhproject.helper

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageHelper {

    fun loadImage(context: Context, imageUrl: String, placeHolderResourceId: Int, imageView: ImageView) {
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(placeHolderResourceId)
                .into(imageView)
    }

}