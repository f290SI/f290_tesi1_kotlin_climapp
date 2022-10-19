package dev.esdras.f290_tesi1_kotlin_climapp

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dev.esdras.f290_tesi1_kotlin_climapp.model.Weather

        //import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

// Jose Carlos, Guilherme, Willian, Ricardo, Rubens, Victor, Bruna


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //<editor-fold desc="VIEWS" defaultstate="collapsed">

        //</editor-fold>

        //<editor-fold desc="Animacao Gradiente" defaultstate="collapsed">
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val bg = findViewById<View>(R.id.root_layout)

        val animDrawable = bg.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(100)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        //</editor-fold>

        var mapper = jacksonObjectMapper()
        var wheather: Weather?

        val url = "https://api.hgbrasil.com/weather"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                Log.d("RESULT: ", response)

            },
            { error -> error.localizedMessage?.let { Log.d("ERROR: ", it) } })

        queue.add(stringRequest)
    }
}