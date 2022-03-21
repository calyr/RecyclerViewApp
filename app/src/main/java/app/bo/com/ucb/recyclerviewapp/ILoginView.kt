package app.bo.com.ucb.recyclerviewapp

interface ILoginView {
    fun sendData(userName: String, password: String )
    fun showMessage(message: String)
    fun gotoHome()

}