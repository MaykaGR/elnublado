/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.elnublado

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var image : ImageView
    lateinit var textView: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loggin)
        //setContentView(R.layout.activity_main)
        val nam: EditText = findViewById(R.id.nam)
        val pass: EditText = findViewById(R.id.pass)
        val log: Button = findViewById(R.id.logb)
        log.setOnClickListener{setContentView(R.layout.activity_main)
            var palabra: TextView = findViewById(R.id.palabra)
            palabra.text = palabra()
            var palabraArr = palabra.text.toString().toCharArray()
            var sString = ""
            val label1: TextView = findViewById(R.id.label1)
            val econtador: TextView = findViewById(R.id.contador_errores)
            val label2: TextView = findViewById(R.id.label2)
            val pcontador: TextView = findViewById(R.id.contador_puntos)
            val texto: EditText = findViewById(R.id.editable)
            val rollButton: Button = findViewById(R.id.roll_button)
            textView = findViewById(R.id.coded_text)
            var s = CharArray(palabraArr.size)
            for(i in 0..palabraArr.size-1){
                s[i] = '*'
            }
            for(i in 0..s.size-1){
                sString = sString+s[i]
            }
            sString = sString.trim()
            textView.text = sString

            rollButton.setOnClickListener { econtador.text = enterLetter(texto.text.toString().trim(),palabraArr, econtador.text.toString())
                textView.text = encoded(texto.text.toString().trim(),textView.text.toString(), palabraArr)
                pcontador.text = contadorPuntos(textView.text.toString(), palabraArr, pcontador.text.toString())
                if(econtador.text.toString().toInt()>10){
                    econtador.text = "0"
                    rollButton.setOnClickListener { System.exit(0) }
                }
                if(textView.text.toString()==palabra.text.toString()){
                    palabra.text = palabra()
                    palabraArr = palabra.text.toString().toCharArray()
                    textView.text = encoded(texto.text.toString().trim(),textView.text.toString(), palabraArr)
                }
            //rollButton.isClickable = false
                //rollButton.setTextColor(1)
            }
            image = findViewById<ImageView>(R.id.image)
            println(palabra)}
        /*var palabra: TextView = findViewById(R.id.palabra)
        palabra.text = palabra()
        var palabraArr = palabra.text.toString().toCharArray()
        var sString = ""
        val label1: TextView = findViewById(R.id.label1)
        val econtador: TextView = findViewById(R.id.contador_errores)
        val label2: TextView = findViewById(R.id.label2)
        val pcontador: TextView = findViewById(R.id.contador_puntos)
        val texto: EditText = findViewById(R.id.editable)
        val rollButton: Button = findViewById(R.id.roll_button)
        textView = findViewById(R.id.coded_text)
        var s = CharArray(palabraArr.size)
        for(i in 0..palabraArr.size-1){
            s[i] = '*'
        }
        for(i in 0..s.size-1){
            sString = sString+s[i]
        }
        sString = sString.trim()
        textView.text = sString

        rollButton.setOnClickListener { econtador.text = enterLetter(texto.text.toString().trim(),palabraArr, econtador.text.toString())
                                            textView.text = encoded(texto.text.toString().trim(),textView.text.toString(), palabraArr)
                                            pcontador.text = contadorPuntos(textView.text.toString(), palabraArr, pcontador.text.toString())
            if(econtador.text.toString().toInt()>10){
                econtador.text = "0"
                rollButton.setOnClickListener { System.exit(0) }
            }
            if(textView.text.toString()==palabra.text.toString()){
                palabra.text = palabra()
                palabraArr = palabra.text.toString().toCharArray()
                textView.text = encoded(texto.text.toString().trim(),textView.text.toString(), palabraArr)
            }}
        image = findViewById<ImageView>(R.id.image)
        println(palabra)*/
    }

    private fun contadorPuntos(view: String, palabra: CharArray, puntos: String): String{
        var p = puntos.toInt()
        var charView = view.toCharArray()
        var iguales = true
        var i = 0
        while(i<palabra.size&&iguales){
            if(charView[i]=='*'){
                iguales = false
            } else{
                i = i+1
            }
        }
        if(iguales==true){
            return (p+1).toString()
        } else{
            return p.toString()
        }
    }

    private fun encoded(texto: String, view: String, palabra: CharArray): String{
        var sString = ""
        var s = view.toCharArray()
        var c = texto.toCharArray()[0]
        for(i in 0..palabra.size-1){
            if(palabra[i]==c){
                s[i]=c} }
        for(i in 0..s.size-1){
            sString = sString+s[i]
        }
        sString = sString.trim()

        return sString
    }

    private fun enterLetter(texto: String, palabra: CharArray, errores: String): String {
        for(i in 0..palabra.size-1){
            print(palabra[i])
        }
        var encontrado = false

        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        var err = errores.toInt()
        var c = texto.toCharArray()[0]
        var contador = 0
        while(contador<palabra.size&&!encontrado){
            for(i in 0..palabra.size-1){
                if(palabra[i]==c){
                    encontrado = true
                }
                else{
                    contador = contador+1
                }
            }
        }
        if(encontrado==false){
            err = err+1
        }

        val drawableResource = when (err) {
            0 -> R.drawable.pas1_1
            1 -> R.drawable.pas1_2
            2 -> R.drawable.pas1_3
            3 -> R.drawable.pas1_4
            4 -> R.drawable.pas1_5
            5 -> R.drawable.pas1_6
            6 -> R.drawable.pas1_7
            7 -> R.drawable.pas1_8
            8 -> R.drawable.pas1_9
            9 -> R.drawable.pas2_1
            10 -> R.drawable.pas2_2
            else -> R.drawable.end
        }

        image.setImageResource(drawableResource)
        return err.toString()
    }


    private fun palabra(): String{
        val diccionario = arrayOf("humanidad", "humano" ,"persona" ,"gente" ,"hombre" ,"mujer" ,"bebe" ,"niño", "niña", "adolescente",
            "adulto", "adulta", "anciano", "anciana" ,"don", "doña" ,"señor", "señora" ,"caballero" ,"dama" ,"individuo","cuerpo",
            "pierna", "pie", "talon" ,"espinilla" ,"rodilla", "cabeza","nariz" ,"cabello", "oreja", "cerebro" ,"uña", "muñeca" ,"abdomen",
            "sangre" ,"familia" ,"criatura" ,"especie", "vida" ,"naturaleza", "animal" ,"perro" ,"gato", "caballo", "yegua",
            "cuervo", "mariposa", "polilla", "saltamontes", "araña" ,"mosquito" ,"cucaracha", "caracol", "planeta", "sol", "luna",
            "estrella", "galaxia", "universo" ,"tormenta" ,"izquierda","diagonal" ,"retroceso", "existencia","bajo")
        var palabra = diccionario.random()
        println(palabra)
        return palabra
    }

}
