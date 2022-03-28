package app.bo.com.ucb.recyclerviewapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val model: LiveData<UiModel>
        get() {
            return _model
        }

    sealed class UiModel {
        object Loading: UiModel()
        class Login() : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()

    fun login(userName: String, password: String) {
        _model.value = UiModel.Loading
        _model.value = UiModel.Login()
    }
}