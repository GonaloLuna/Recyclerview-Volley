package com.example.bdcontactos

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        val queue = Volley.newRequestQueue(this)
        var url = "http://iesayala.ddns.net/GonzaloLuna/registro.php"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            val contactos = response.getJSONArray("contactos")
            Log.d("Json", contactos.toString())
            recycler.adapter = Adapter(contactos)
        },
                Response.ErrorListener { error -> Log.d("JSON", error.toString()) })

        queue.add(jsonObjectRequest)
    }


}