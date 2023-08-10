package com.alblu.ejalisco

import android.database.sqlite.SQLiteDatabase
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.alblu.ejalisco.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var datosconsultasDBHelper: miSQLiteHelper2
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datosconsultasDBHelper = miSQLiteHelper2(this)

        val db: SQLiteDatabase = datosconsultasDBHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM datosconsultas",
            null)

        binding.textR.text = ""
 

        if (cursor.moveToFirst()) {
            do {
                val textBuilder = SpannableStringBuilder()

                val institutionText = "${cursor.getString(8)}\n"
                val institutionStart = textBuilder.length
                textBuilder.append(institutionText)
                val textSize = 60 // Tamaño de letra deseado

                textBuilder.setSpan(AbsoluteSizeSpan(textSize), institutionStart, textBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                textBuilder.setSpan(StyleSpan(Typeface.BOLD), institutionStart, textBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

                binding.textR.append(textBuilder)

                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                layoutParams.setMargins(8, 0, 0, 0)
                binding.imageView.layoutParams = layoutParams

                binding.textR.append("Clave del inmueble: ${cursor.getString(0)}\n")
                binding.textR.append("Tecnología Instalada: ${cursor.getString(1)}\n")
                binding.textR.append("Ancho de banda: ${cursor.getString(2)}\n\n")



            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()

    }
}