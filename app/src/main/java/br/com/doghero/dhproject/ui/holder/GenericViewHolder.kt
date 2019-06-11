package br.com.doghero.dhproject.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class GenericViewHolder<HeroItem>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var item: HeroItem? = null

    open fun onBindViewHolder(item: HeroItem) {
        this.item = item
    }

}