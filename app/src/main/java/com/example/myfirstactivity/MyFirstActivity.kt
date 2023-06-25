package com.example.myfirstactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class MyFirstActivity : Activity() {
    lateinit var tvContador : TextView
    lateinit var btnButton: Button
    private lateinit var lstv: ListView

    var contador = 0
    //val listView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_my_first)

        tvContador = findViewById(R.id.tvContador)
        btnButton = findViewById(R.id.btnBoton)
        
        btnButton.setOnClickListener {
            contador++
            tvContador.text = contador.toString()
            //Toast.makeText(this,contador.toString(),Toast.LENGTH_LONG).show()

        }

        var lista = listOf<String>("DatoO", "Dato1","Dato2","Dato3")
        lstv = findViewById(R.id.lstv)


        //var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
        val adapter = AdapterList(this, lista)
        lstv.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        //todo mandar mensaje
        //  Toast.makeText(this,"Hola my Love",Toast.LENGTH_LONG).show()
        /*
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data= Uri.parse("https://www.google.com")
        startActivity(intent)

        val intent = Intent(this,MySecondActivity::class.java)
        startActivity(intent) */

        }

        class AdapterList(val contex : Context, var lista : List<String>) : BaseAdapter(){

            override fun getCount(): Int {
                return lista.size

            }

            override fun getItem(p0: Int): Any {
                return lista[p0]
            }

            override fun getItemId(p0: Int): Long {
                return p0.toLong()
            }

            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                var vista: View
                var holder: ViewHolder = ViewHolder()

                // if(p1 == null) {

                vista = LayoutInflater.from(contex).inflate(R.layout.item_lista, p2, false)
                holder.tvItem = vista.findViewById(R.id.tvItem)
                vista.tag = holder
            //}
                    var nombre = lista[p0]
                    holder.tvItem?.text = nombre

                    return vista

            }

        }
    class ViewHolder {
        var tvItem : TextView? = null
    }
}
