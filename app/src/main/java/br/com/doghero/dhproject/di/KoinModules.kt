package br.com.doghero.dhproject.di

import br.com.doghero.dhproject.data.source.MyHeroesInteractor
import br.com.doghero.dhproject.ui.MyHeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myHeroesModule = module {
    factory { MyHeroesInteractor() }
    viewModel { MyHeroesViewModel(get()) }
}