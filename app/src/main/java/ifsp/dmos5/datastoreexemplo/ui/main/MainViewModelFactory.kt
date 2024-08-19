package ifsp.dmos5.datastoreexemplo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ifsp.dmos5.datastoreexemplo.data.repository.UserRepository

class MainViewModelFactory (
    private val userRepository: UserRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(userRepository) as T
        }
        throw  IllegalAccessException("View Model desconhecido")
    }


}