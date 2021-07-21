package com.fry.usernamekeep

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //var sharedPreferences : SharedPreferences? = null
    lateinit var sharedPreferences : SharedPreferences
    var inputName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences

        sharedPreferences = this.getSharedPreferences("com.fry.usernamekeep",
                Context.MODE_PRIVATE)

        inputName = sharedPreferences.getString("Name","").toString()

        if (inputName != null){
            textView.text = "Kaydedilen Kullanici Adi: ${inputName}"
        }
    }

    fun save(view:View){

        val userName = editText.text.toString()

        if (userName == ""){
            Toast.makeText(this,"Please enter a value",Toast.LENGTH_LONG).show()
        }else{
            sharedPreferences.
                            edit().
                            putString("Name",userName).
                            apply()
            textView.text = "Kaydedilen Değer: ${userName}"
         }


    }

    fun delete(view:View){

        inputName = sharedPreferences.getString("Name","").toString()

        if(inputName != null){
            textView.text = "Kaydedilen Kullanıcı Adı: "
            sharedPreferences.
                        edit().
                        remove("Name").
                        apply()
        }

    }
}