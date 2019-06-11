package br.com.doghero.dhproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.data.model.Hero
import br.com.doghero.dhproject.data.model.HeroItem
import br.com.doghero.dhproject.ui.holder.HeaderViewHolder
import br.com.doghero.dhproject.ui.holder.HeroViewHolder
import br.com.doghero.dhproject.ui.holder.GenericViewHolder

class MyHeroesGenericAdapter: RecyclerView.Adapter<GenericViewHolder<HeroItem>>() {

    private var items: MutableList<HeroItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<HeroItem> {
        return when(viewType) {
            MyHeroesGenericType.HERO.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_my_hero, parent, false)
                HeroViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_section, parent, false)
                HeaderViewHolder(view)
            }
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GenericViewHolder<HeroItem>, position: Int) {
        val item = items[position]
        holder.onBindViewHolder(item)
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is Hero -> {
                MyHeroesGenericType.HERO.ordinal
            }
            else -> {
                MyHeroesGenericType.HEADER.ordinal
            }
        }
    }

    fun setItems(items: ArrayList<HeroItem>) {
        this.items.clear()
        this.items = items
        notifyDataSetChanged()
    }

    enum class MyHeroesGenericType {

        HEADER,
        HERO

    }

}