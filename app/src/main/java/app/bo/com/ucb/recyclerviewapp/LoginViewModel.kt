package app.bo.com.ucb.recyclerviewapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val loginRepository: LoginRepository) : ViewModel() {
    val model: LiveData<UiModel>
        get() {
            return _model
        }

    sealed class UiModel {
        class Loading(): UiModel()
        class Login(val resp: Response<String>) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()

    fun login(userName: String, password: String) {
        _model.value = UiModel.Loading()
        _model.value = UiModel.Login( loginRepository.login(userName, password))
    }
}