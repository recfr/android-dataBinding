package com.recep.aboutwho

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.recep.aboutwho.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val personInformation = PersonInformation("Recep")

//    lateinit var surnameEditText: EditText
//    lateinit var surnameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        /**
         * Data Binding kullanımı yapabilmek için setContentView'ı DataBindingUtil üzerinden
         * inflate etmek gerekiyor. Layout ile activity arasındaki bağlantıyı bu şekilde sağlıyoruz.
         */

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.info = personInformation
        binding.doneButton.setOnClickListener {
            addSurname(it)
        }
//        val doneButton = findViewById(R.id.done_button)
//        doneButton.setOnClickListener {
//            addSurname()
//        }
//
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addSurname(it)
//        }


//        surnameEditText = findViewById(R.id.surname_edit)
//        surnameText = findViewById(R.id.surname_text)
    }

    private fun addSurname(view: View) {

        binding.apply {
//            surnameText.text = surnameEdit.text
            info?.surname = surnameEdit.text.toString()
            invalidateAll()
            doneButton.visibility = View.GONE
            surnameEdit.visibility = View.GONE
            surnameText.visibility = View.VISIBLE
        }

//        surnameText.text = surnameEditText.text
//        surnameEditText.visibility = View.GONE
//        view.visibility = View.GONE
//        surnameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}