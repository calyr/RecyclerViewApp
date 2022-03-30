package app.bo.com.ucb.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    lateinit var userName: EditText
    lateinit var userPassword: EditText
    lateinit var btnLogin : Button
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userName = findViewById(R.id.user_name_login)
        userPassword = findViewById(R.id.user_password_login)
        btnLogin = findViewById(R.id.btn_login)
        loginViewModel = LoginViewModel(LoginRepository())
        progressBar = findViewById(R.id.progressBar)

        loginViewModel.model.observe(this, Observer(::updateUi))

        btnLogin.setOnClickListener {
            loginViewModel.login(userName.text.toString(), userPassword.text.toString())
        }

    }

    private fun updateUi(uiModel: LoginViewModel.UiModel?) {
        progressBar.visibility = if ( uiModel is LoginViewModel.UiModel.Loading) View.VISIBLE else View.GONE
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