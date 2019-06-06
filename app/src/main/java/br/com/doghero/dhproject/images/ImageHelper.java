package br.com.doghero.dhproject.images;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageHelper {
    public static void loadImage(Context context, String imageUrl, int placeHolderResourceId, ImageView imageView) {
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(placeHolderResourceId)
                .into(imageView);
    }
}
