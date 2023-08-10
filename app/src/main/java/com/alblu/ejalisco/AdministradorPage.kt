package com.alblu.ejalisco

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.alblu.ejalisco.databinding.ActivityAdministradorPageBinding

class AdministradorPage : AppCompatActivity() {
    private lateinit var binding: ActivityAdministradorPageBinding
    lateinit var  datosconsultasDBHelper : miSQLiteHelper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdministradorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datosconsultasDBHelper = miSQLiteHelper2(this)

        binding.buttonAgregar.setOnClickListener {
            if (binding.editTextClave.text.isNotBlank() &&
                binding.editTextTecIns.text.isNotBlank() &&
                binding.editTextAncBand.text.isNotBlank() &&
                binding.editTextInst.text.isNotBlank() &&
                binding.editTextNomCen.text.isNotBlank() &&
                binding.editTextTurHor.text.isNotBlank() &&
                binding.editTextNiv.text.isNotBlank() &&
                binding.editTextReg.text.isNotBlank() &&
                binding.editTextMun.text.isNotBlank() &&
                binding.editTextLoc.text.isNotBlank() &&
                binding.editTextDom.text.isNotBlank() &&
                binding.editTextLong.text.isNotBlank() &&
                binding.editTextLat.text.isNotBlank() &&
                binding.editTextEst.text.isNotBlank()
            ) {
                val codigo = binding.editTextCod.text.toString()
                if (codigo.isNotBlank() && codigo.toIntOrNull() != null) {
                    datosconsultasDBHelper.anyadirDato(
                        binding.editTextClave.text.toString(),
                        binding.editTextTecIns.text.toString(),
                        binding.editTextAncBand.text.toString(),
                        binding.editTextInst.text.toString(),
                        binding.editTextNomCen.text.toString(),
                        binding.editTextTurHor.text.toString(),
                        binding.editTextNiv.text.toString(),
                        binding.editTextReg.text.toString(),
                        binding.editTextMun.text.toString(),
                        binding.editTextLoc.text.toString(),
                        binding.editTextCod.text.toString(),
                        codigo.toInt(),
                        binding.editTextLong.text.toString(),
                        binding.editTextLat.text.toString(),
                        binding.editTextEst.text.toString()
                    )

                    binding.editTextClave.text.clear()
                    binding.editTextTecIns.text.clear()
                    binding.editTextAncBand.text.clear()
                    binding.editTextInst.text.clear()
                    binding.editTextNomCen.text.clear()
                    binding.editTextTurHor.text.clear()
                    binding.editTextNiv.text.clear()
                    binding.editTextReg.text.clear()
                    binding.editTextMun.text.clear()
                    binding.editTextLoc.text.clear()
                    binding.editTextDom.text.clear()
                    binding.editTextCod.text.clear()
                    binding.editTextLong.text.clear()
                    binding.editTextLat.text.clear()
                    binding.editTextEst.text.clear()

                    Toast.makeText(this, "Guardado...",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ingrese un código válido...",
                        Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "Llene todos los campos...",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonEliminar.setOnClickListener{

            var cantidad = 0

            if (binding.editTextClave.text.isNotBlank()) {
                cantidad = datosconsultasDBHelper.borrarDato(
                    binding.editTextClave.text.toString() )

                binding.editTextClave.text.clear()
            }
            else {
                Toast.makeText(this,
                    "Datos borrados:  $cantidad",
                    Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonModificar.setOnClickListener {
            if (binding.editTextClave.text.isNotBlank() &&
                binding.editTextTecIns.text.isNotBlank() &&
                binding.editTextAncBand.text.isNotBlank() &&
                binding.editTextInst.text.isNotBlank() &&
                binding.editTextNomCen.text.isNotBlank() &&
                binding.editTextTurHor.text.isNotBlank() &&
                binding.editTextNiv.text.isNotBlank() &&
                binding.editTextReg.text.isNotBlank() &&
                binding.editTextMun.text.isNotBlank() &&
                binding.editTextLoc.text.isNotBlank() &&
                binding.editTextDom.text.isNotBlank() &&
                binding.editTextLong.text.isNotBlank() &&
                binding.editTextLat.text.isNotBlank() &&
                binding.editTextEst.text.isNotBlank()
            ) {
                val codigo = binding.editTextCod.text.toString()
                if (codigo.isNotBlank() && codigo.toIntOrNull() != null) {
                    datosconsultasDBHelper.ModificarDato(
                        binding.editTextClave.text.toString(),
                        binding.editTextTecIns.text.toString(),
                        binding.editTextAncBand.text.toString(),
                        binding.editTextInst.text.toString(),
                        binding.editTextNomCen.text.toString(),
                        binding.editTextTurHor.text.toString(),
                        binding.editTextNiv.text.toString(),
                        binding.editTextReg.text.toString(),
                        binding.editTextMun.text.toString(),
                        binding.editTextLoc.text.toString(),
                        binding.editTextCod.text.toString(),
                        codigo.toInt(),
                        binding.editTextLong.text.toString(),
                        binding.editTextLat.text.toString(),
                        binding.editTextEst.text.toString()
                    )

                    binding.editTextClave.text.clear()
                    binding.editTextTecIns.text.clear()
                    binding.editTextAncBand.text.clear()
                    binding.editTextInst.text.clear()
                    binding.editTextNomCen.text.clear()
                    binding.editTextTurHor.text.clear()
                    binding.editTextNiv.text.clear()
                    binding.editTextReg.text.clear()
                    binding.editTextMun.text.clear()
                    binding.editTextLoc.text.clear()
                    binding.editTextDom.text.clear()
                    binding.editTextCod.text.clear()
                    binding.editTextLong.text.clear()
                    binding.editTextLat.text.clear()
                    binding.editTextEst.text.clear()

                    Toast.makeText(this, "Modificado",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ingrese un código válido...",
                        Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "Los campos no deben estar vacios...",
                    Toast.LENGTH_LONG).show()
            }
        }

    }
}