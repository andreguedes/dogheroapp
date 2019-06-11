package br.com.doghero.dhproject.ui.holder

import android.view.View
import br.com.doghero.dhproject.data.model.Header
import br.com.doghero.dhproject.data.model.HeroItem
import kotlinx.android.synthetic.main.rv_item_section.view.*

class HeaderViewHolder(itemView: View) : GenericViewHolder<HeroItem>(itemView) {

    override fun onBindViewHolder(item: HeroItem) {
        super.onBindViewHolder(item)

        if (item is Header) {
            with(itemView) {
                txt_my_heroes_section_title.text = context.getString(item.headerTitle)
            }
        }
    }

}