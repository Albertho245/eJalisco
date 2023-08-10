package com.alblu.ejalisco

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alblu.ejalisco.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var cuentasDBHelper: miSQLiteHelper
    lateinit var datosconsultasDBHelper: miSQLiteHelper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cuentasDBHelper = miSQLiteHelper(this)
        datosconsultasDBHelper = miSQLiteHelper2(this)


        binding.buttonRegist.setOnClickListener {
            val intent = Intent(this, RegiterActivity::class.java)
            startActivity(intent)
        }

        binding.olvidecontrasena.setOnClickListener{
            val db : SQLiteDatabase = datosconsultasDBHelper.readableDatabase
            db.close()
            Toast.makeText(this, "Que mal... :(",
                Toast.LENGTH_LONG).show()
        }

        binding.ingresar.setOnClickListener{
            val db : SQLiteDatabase = cuentasDBHelper.readableDatabase
            //Tomamos los datos de las casillas
            val valorCorreo = binding.correo.text.toString()
            val valorContrasena = binding.contrasena.text.toString()

            val selection = "correo = ? AND contrasena = ?"
            val selectionArgs = arrayOf(valorCorreo, valorContrasena)

            val cursor = db.query(
                "cuentas",
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
            )


            //Agregar el cambio de pantalla entre admin y usuario
            if (cursor != null && cursor.moveToFirst()) {
                Toast.makeText(this, "Iniciando Sesion", Toast.LENGTH_SHORT).show()
                val admin = cursor.getInt(3)
                val intent = if (admin == 0) {
                    Intent(this, HomePage::class.java)
                } else {
                    Intent(this, AdministradorPage::class.java)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Correo o contraseña invalida", Toast.LENGTH_LONG).show()
            }


            cursor?.close()
            db.close()
        }

    }
}

