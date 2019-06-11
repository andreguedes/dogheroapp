package br.com.doghero.dhproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.doghero.dhproject.data.source.MyHeroesInteractor
import kotlinx.coroutines.*

class MyHeroesViewModel(
    private val myHeroesInteractor: MyHeroesInteractor,
    mainDispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    private val job = SupervisorJob()
    private val state = MutableLiveData<MyHeroesViewState>()
    private val scope = CoroutineScope(mainDispatcher + job)
    val viewState: LiveData<MyHeroesViewState> = state

    fun getMyHeroes() {
        scope.launch {
            val myHeroesResponse = myHeroesInteractor.getMyHeroes()
            myHeroesResponse.let {
                if (it.isNullOrEmpty()) {
                    state.value = MyHeroesViewState.EmptyHeroesList
                } else {
                    state.value = MyHeroesViewState.MyHeroesList(it)
                }
            }
        }
    }

}