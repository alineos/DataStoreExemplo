package ifsp.dmos5.datastoreexemplo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ifsp.dmos5.datastoreexemplo.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val userRepository: UserRepository
): ViewModel() {

    private val _username = MutableStateFlow<String?>(null)
    val username: StateFlow<String?> = _username

    init {
        viewModelScope.launch {
            userRepository.usernameFlow.collect{
                _username.value = it
            }
        }
    }

    fun save(username: String){
        viewModelScope.launch {
            userRepository.saveUsername(username)
        }
    }
}