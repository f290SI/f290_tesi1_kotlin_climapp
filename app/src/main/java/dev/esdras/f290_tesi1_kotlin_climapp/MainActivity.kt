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
        val tvTemperatura = findViewById<TextView>(R.id.textViewTemperatura)
        val tvCidade = findViewById<TextView>(R.id.textViewCidade)
        val tvTempMaxima = findViewById<TextView>(R.id.textViewMaxima)
        val tvTempMinima = findViewById<TextView>(R.id.textViewMinima)
        val tvTempoCelula = findViewById<TextView>(R.id.textViewTempoCelula)
        val tvNascerDoSol = findViewById<TextView>(R.id.textViewNascerDoSol)
        val tvPorDoSol = findViewById<TextView>(R.id.textViewPorDoSol)

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
        var weather: Weather?

        val url = "https://api.hgbrasil.com/weather"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                Log.d("RESULT: ", response)
                val nodeResult = mapper.readTree(response)
                weather = mapper.readValue(nodeResult.get("results").toString(),
                    Weather::class.java)

                tvTemperatura.text = weather?.temp.toString()
                tvCidade.text = weather?.city
                tvTempMaxima.text = weather?.forecast?.get(0)?.max.toString()
                tvTempMinima.text = weather?.forecast?.get(0)?.min.toString()
                tvNascerDoSol.text = weather?.sunrise
                tvPorDoSol.text = weather?.sunrise
                tvTempoCelula.text = weather?.description

                Log.i("JACKSON:", weather.toString())
            },
            { error -> error.localizedMessage?.let { Log.d("ERROR: ", it) } })

        queue.add(stringRequest)
    }
}