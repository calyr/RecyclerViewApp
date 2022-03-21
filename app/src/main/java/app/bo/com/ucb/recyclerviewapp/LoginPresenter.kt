package app.bo.com.ucb.recyclerviewapp

import android.content.Context

class LoginPresenter(val loginView: ILoginView, val context: Context) : ILoginPresenter {
    override fun login(userName: String, password: String) {
        if( userName == "calyr") {
            loginView.gotoHome()
        } else {
            loginView.showMessage( context.getString( R.string.login_error_session ))
        }
    }
}