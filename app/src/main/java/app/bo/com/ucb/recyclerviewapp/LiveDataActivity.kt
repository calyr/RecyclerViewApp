package app.bo.com.ucb.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class LiveDataActivity : AppCompatActivity() {



    val liveDataString: LiveDataString by viewModels()
    lateinit var btnIncrement : Button
    lateinit var txtString : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        btnIncrement = findViewById(R.id.increment_button)
        txtString = findViewById(R.id.string_text_view)

        liveDataString.cadena.observe(this, Observer(::updateUi))

        btnIncrement.setOnClickListener {
            liveDataString.cambiar()
        }

    }

    private fun updateUi(s: String?) {
        txtString.text = s!!
    }
}