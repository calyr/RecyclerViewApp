package app.bo.com.ucb.recyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), ILoginView {

    lateinit var loginPresenter: ILoginPresenter
    lateinit var loginButton: Button
    lateinit var userName: EditText
    lateinit var userPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton = findViewById(R.id.login_button)
        userName = findViewById(R.id.user_name_edit_text)
        userPassword = findViewById(R.id.user_password_edit_text)
        loginPresenter = LoginPresenter(this, applicationContext)
    }

    override fun sendData(view: View) {
        loginPresenter.login( userName.text.toString(), userPassword.text.toString())
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG ).show()
    }

    override fun gotoHome() {
        startActivity(Intent(this, HomeActivity::class.java ))
    }
}