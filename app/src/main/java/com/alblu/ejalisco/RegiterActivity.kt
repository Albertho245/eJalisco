
package com.alblu.ejalisco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alblu.ejalisco.databinding.ActivityRegiterBinding


class RegiterActivity : AppCompatActivity() {

        lateinit var binding: ActivityRegiterBinding
        lateinit var cuentasDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegiterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regreso.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.registro2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        cuentasDBHelper = miSQLiteHelper(this)

        binding.bottonDeRegistro.setOnClickListener {
            if ( binding.editTextTextEmailAddress.text.isNotBlank() &&
                binding.namefom.text.isNotBlank() &&
                binding.editTextTextPassword.text.isNotBlank()) {

                val switch1 = binding.switch1.isChecked

                cuentasDBHelper.anyadirDato(binding.editTextTextEmailAddress.text.toString(),
                    binding.namefom.text.toString(),
                    binding.editTextTextPassword.text.toString(),
                    switch1)

                binding.editTextTextEmailAddress.text.clear()
                binding.namefom.text.clear()
                binding.editTextTextPassword.text.clear()

                Toast.makeText(this, "Registrado ",
                    Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Intentelo de nuevo... ",
                Toast.LENGTH_SHORT).show()
            }
        }



    }
}

