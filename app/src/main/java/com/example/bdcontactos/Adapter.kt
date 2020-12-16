package com.example.bdcontactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contactos_rows.view.*
import org.json.JSONArray
import org.json.JSONObject

class Adapter (private val contacto: JSONArray)
    : RecyclerView.Adapter<Adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contactos_rows, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val tel: TextView = view.textTelefono
        val nom: TextView = view.textNombre
        val ape: TextView = view.textApellido
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contacto: JSONObject = contacto.getJSONObject(position)
        holder.tel.text = contacto["telefono"].toString()
        holder.nom.text = contacto["nombre"].toString()
        holder.ape.text = contacto["apellido"].toString()

    }

    override fun getItemCount(): Int = contacto.length()

}