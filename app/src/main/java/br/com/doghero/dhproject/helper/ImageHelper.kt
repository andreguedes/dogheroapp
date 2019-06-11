package br.com.doghero.dhproject.helper

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageHelper {

    private fun loadImage(context: Context): Picasso {
        return Picasso.with(context)
    }

    fun loadImage(context: Context, imageUrl: String, placeHolderResourceId: Int, imageView: ImageView) {
        this.loadImage(context)
                .load(imageUrl)
                .placeholder(placeHolderResourceId)
                .into(imageView)
    }

    fun loadImage(context: Context, imageId: Int, placeHolderResourceId: Int, imageView: ImageView) {
        this.loadImage(context)
                .load(imageId)
                .placeholder(placeHolderResourceId)
                .into(imageView)
    }

}