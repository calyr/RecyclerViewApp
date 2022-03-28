package app.bo.com.ucb.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = LoginViewModel(LoginRepository())

        loginViewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(uiModel: LoginViewModel.UiModel?) {
        when (uiModel) {
            is LoginViewModel.UiModel.Login -> validateLogin(uiModel.resp)
        }
//        if ( uiModel == LoginViewModel.UiModel.Loading()) {
//            //mostrar Loading
//        } else if( uiModel == LoginViewModel.UiModel.Login()) {
//
//        }
    }

    private fun validateLogin(resp: Response<String>) {
        if ( resp.code == 0) {
            Toast.makeText(this, resp.message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, resp.message, Toast.LENGTH_LONG).show()
        }
    }
}