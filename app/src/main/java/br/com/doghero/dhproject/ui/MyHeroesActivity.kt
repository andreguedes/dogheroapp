package br.com.doghero.dhproject.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.data.model.*
import kotlinx.android.synthetic.main.activity_my_heroes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyHeroesActivity : AppCompatActivity() {

    private val myHeroesViewModel: MyHeroesViewModel by viewModel()
    private lateinit var myHeroesAdapter: MyHeroesGenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_heroes)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        initUI()
        initData()
    }

    private fun initUI() {
        myHeroesAdapter = MyHeroesGenericAdapter()

        with(rv_my_heroes) {
            itemAnimator = DefaultItemAnimator()
            this.layoutManager = LinearLayoutManager(context)
            adapter = myHeroesAdapter
        }
    }

    private fun initData() {
        myHeroesViewModel.getMyHeroes()
        myHeroesViewModel.viewState.observe(this, Observer {
            when(it) {
                is MyHeroesViewState.MyHeroesList -> setItems(it.heroesList)
                is MyHeroesViewState.EmptyHeroesList -> showEmptyMessage()
            }
        })
    }

    private fun setItems(items: ArrayList<HeroItem>) {
        myHeroesAdapter.setItems(items)
    }

    private fun showEmptyMessage() {
        txt_empty_message.visibility = View.VISIBLE
    }

}