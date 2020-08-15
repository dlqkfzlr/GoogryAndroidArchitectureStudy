package m.woong.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import m.woong.sun_library.data.repos.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val date: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}