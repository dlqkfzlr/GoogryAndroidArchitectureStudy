package study.architecture.mainjob

import study.architecture.BaseViewModel
import study.architecture.coinjob.CoinFragment

class MainViewModel : BaseViewModel() {
    val pageLimit: Int = CoinFragment.FragIndex.values().size

    override fun onResume() {

    }
}