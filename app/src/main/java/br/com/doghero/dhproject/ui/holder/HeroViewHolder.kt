package br.com.doghero.dhproject.ui.holder

import android.graphics.Typeface
import android.text.SpannableString
import android.view.View
import br.com.doghero.dhproject.data.model.Hero
import br.com.doghero.dhproject.data.model.HeroItem
import br.com.doghero.dhproject.helper.ImageHelper
import kotlinx.android.synthetic.main.rv_item_my_hero.view.*
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.net.Uri
import android.widget.ImageView
import br.com.doghero.dhproject.BuildConfig
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.data.model.HeroStatus

class HeroViewHolder(itemView: View) : GenericViewHolder<HeroItem>(itemView) {

    override fun onBindViewHolder(item: HeroItem) {
        super.onBindViewHolder(item)

        if (item is Hero) {
            with(itemView) {
                txt_hero_neighborhood.text = item.addressNeighborhood

                rt_hero_stars.rating = (1..5).random().toFloat() //Random number, because I don't know where this information is available
                txt_hero_rating_count.text = (1..250).random().toString() //The same case like above

                if (item.heroStatus == HeroStatus.FAVORITE) {
                    img_hero_heart.visibility = View.VISIBLE
                    img_hero_heart.setOnClickListener {
                        item.isFavorite = !item.isFavorite
                        setFavorite(item.isFavorite, img_hero_heart)
                    }
                    setFavorite(item.isFavorite, img_hero_heart)
                }

                val priceFormatted = String.format(context.getString(R.string.money_format), item.price)
                val text = SpannableString(priceFormatted)
                text.setSpan(
                    StyleSpan(Typeface.BOLD), 2, text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                txt_hero_price.text = SpannableStringBuilder().append(text)

                item.user?.let {
                    img_superhero.visibility = if (item.isSuperhero) View.VISIBLE else View.GONE
                    txt_hero_name.text = it.firstName
                    ImageHelper.loadImage(
                        itemView.context, it.imageUrl, R.drawable.user_avatar, img_hero_avatar
                    )
                }
            }
        }
    }

    private fun setFavorite(favorite: Boolean, imgHeroHeart: ImageView) {
        if (favorite) {
            val imagePath = Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/drawable/icon_like_filled_vector_red")
            imgHeroHeart.setImageURI(imagePath)
        } else {
            ImageHelper.loadImage(
                itemView.context, R.drawable.icon_like_border_vector_gray_battleship, R.drawable.icon_like_border_vector_gray_battleship, imgHeroHeart
            )
        }
    }

}