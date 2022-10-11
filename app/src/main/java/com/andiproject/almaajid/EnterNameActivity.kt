package com.andiproject.almaajid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EnterNameActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var theName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_name)

        val btnMovetoMain: Button = findViewById(R.id.button_EnterName)
        btnMovetoMain.setOnClickListener(this)

        theName = findViewById(R.id.edt_theName)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button_EnterName -> {
                val inputName = theName.text.toString().trim()
                var isEmptyFields = false

                if (inputName.isEmpty()) {
                    isEmptyFields = true
                    theName.error = "Field ini tidak boleh kosong"
                }

                if (inputName.length > 10){
                    isEmptyFields = true
                    theName.error = "Namamu terlalu panjang hehe"
                }

                if(!isEmptyFields){
                    val moveIntent = Intent(this, MainActivity::class.java)
                    moveIntent.putExtra(MainActivity.EXTRA_NAME, inputName)
                    startActivity(moveIntent)
                }
            }
        }
    }
}