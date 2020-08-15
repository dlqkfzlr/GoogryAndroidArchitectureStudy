package m.woong.myapplication.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(ViewModel::class)
object ViewModelModule {

    @Singleton
    @Binds
    fun bindViewModel(){

    }
}