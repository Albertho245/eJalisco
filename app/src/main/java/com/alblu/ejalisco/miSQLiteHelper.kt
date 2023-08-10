package com.alblu.ejalisco

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class miSQLiteHelper(private val context: Context) : SQLiteOpenHelper(
    context, "cuentas.db", null, 46) {
    override fun onCreate(db: SQLiteDatabase?) {

        val ordenCreacion = "CREATE TABLE cuentas " +
                "(correo TEXT PRIMARY KEY, " +
                "nombre TEXT, " +
                "contrasena TEXT, " +
                "admin INTEGER DEFAULT 0)"
        db!!.execSQL(ordenCreacion)

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS cuentas"
        //val ordenBorrado2 = "DROP TABLE IF EXISTS datosconsulta"
        db!!.execSQL(ordenBorrado)
        //db!!.execSQL(ordenBorrado2)
        onCreate(db)
    }

    fun anyadirDato(correo: String, nombre: String, contrasena: String, admin: Boolean){
        val datos = ContentValues()
        datos.put("correo", correo)
        datos.put("nombre", nombre)
        datos.put("contrasena", contrasena)
        datos.put("admin", if (admin) 1 else 0)

        val db = this.writableDatabase
        db.insert("cuentas", null, datos)
        db.close()
    }

}

//Segunda base de datos
class miSQLiteHelper2(private val context: Context) : SQLiteOpenHelper(
    context, "datosconsultas.db", null, 22) {
    override fun onCreate(db: SQLiteDatabase?) {

        val ordenCreacion = "CREATE TABLE datosconsultas " +
                "(clave_inmueble TEXT PRIMARY KEY, " +
                "tecnologia_instalada TEXT, " +
                "ancho_banda TEXT, " +
                "institucion TEXT, " +
                "nombre_centro TEXT, " +
                "turno_horario TEXT, " +
                "nivel TEXT, " +
                "region TEXT, " +
                "municipio TEXT, " +
                "localidad TEXT, " +
                "domicilio TEXT, " +
                "codigo_postal INTEGER, " +
                "longitud TEXT, " +
                "latitud TEXT, " +
                "estatus TEXT)"
        db!!.execSQL(ordenCreacion)


        val values = ContentValues().apply {
            put("clave_inmueble", "10PLJ21")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "GOB")
            put("nombre_centro", "0")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "COSTA ORTE")
            put("municipio", "PUERTO VALLARTA")
            put("localidad", "0")
            put("domicilio", "CONOCIDO")
            put("codigo_postal", 0)
            put("longitud", "105 13 32.5")
            put("latitud", "20 38 53.7")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values)

        val values2 = ContentValues().apply {
            put("clave_inmueble", "10PLJ22")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "BIBLIOTECAS")
            put("nombre_centro", "0")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "CIENEGA")
            put("municipio", "OCOTLAN")
            put("localidad", "0")
            put("domicilio", "CONOCIDO")
            put("codigo_postal", 0)
            put("longitud", "102 46 30.30")
            put("latitud", "20 21 46.8")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values2)

        val values3 = ContentValues().apply {
            put("clave_inmueble", " 10PLJ23")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "IEEA")
            put("nombre_centro", "0")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "COSTA SUR")
            put("municipio", "VILLA PURIFICACION")
            put("localidad", "0")
            put("domicilio", "ABASOLO 174  COL. CENTRO C.P. 48800")
            put("codigo_postal", 48800)
            put("longitud", "-104.6028806")
            put("latitud", "19.7196083")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values3)

        val values4 = ContentValues().apply {
            put("clave_inmueble", "10PLJ26")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SC")
            put("nombre_centro", "CASA DE LA CULTURA JESUS MARIA")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "ALTOS SUR")
            put("municipio", "JESUS MARIA")
            put("localidad", "JESUS MARIA")
            put("domicilio", "CONSTITUCION 56")
            put("codigo_postal", 0)
            put("longitud", "-102.222694")
            put("latitud", "20.605666")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values4)

        val values5 = ContentValues().apply {
            put("clave_inmueble", "10PLJ27")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "INEEJAD")
            put("nombre_centro", "MEXTICACAN")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "ALTOS SUR")
            put("municipio", "MEXTICACAN")
            put("localidad", "MEXTICACAN")
            put("domicilio", "CMORELOS 1 COL. CENTRO C.P 47340. MEXTICACAN. MEXTICACAN.")
            put("codigo_postal", 47340)
            put("longitud", "104.345.08")
            put("latitud", "214.341.27")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values5)

        val values6 = ContentValues().apply {
            put("clave_inmueble", "10PLJ28")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "BIBLIOTECAS")
            put("nombre_centro", "0")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "CIENEGA")
            put("municipio", "OCOTLAN")
            put("localidad", "0")
            put("domicilio", "HIDALGO 9")
            put("codigo_postal", 0)
            put("longitud", "-102.727756")
            put("latitud", "20.407214")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values6)

        //sin probar
        val values7 = ContentValues().apply {
            put("clave_inmueble", "10PLJ29")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "GOB")
            put("nombre_centro", "0")
            put("turno_horario", "MATUTINO")
            put("nivel", "0")
            put("region", "VALLES")
            put("municipio", "AMECA")
            put("localidad", "0")
            put("domicilio", "CONOCIDO")
            put("codigo_postal", 0)
            put("longitud", "104 2 36.9")
            put("latitud", "20 33 16.3")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values7)



        val values8 = ContentValues().apply {
            put("clave_inmueble", "10PLJ30")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "BENEMERITA Y CENTENARIA ESCUELA NORMAL DE JALISCO")
            put("turno_horario", "MATUTINO")
            put("nivel", "NORMALES")
            put("region", "CENTRO")
            put("municipio", "GUADALAJARA")
            put("localidad", "GUADALAJARA")
            put("domicilio", "AVENIDA PROLONGACION ALCALDE 1190ENTRE AVENIDA DE LOS MAESTROS Y CARLOS PEREYRA")
            put("codigo_postal", 44270)
            put("longitud", "103.220.30")
            put("latitud", "205441")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values8)



        val values9 = ContentValues().apply {
            put("clave_inmueble", "10PLJ31")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "ESCUELA NORMAL EXPERIMENTAL")
            put("turno_horario", "MATUTINO")
            put("nivel", "NORMALES")
            put("region", "NORTE")
            put("municipio", "COLOTLAN")
            put("localidad", "COLOTLAN")
            put("domicilio", "AVENIDA DEL MAESTRO 50")
            put("codigo_postal", 46200)
            put("longitud", "103.416.39")
            put("latitud", "2239.325.33")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values9)


        val values10 = ContentValues().apply {
            put("clave_inmueble", "10PLJ32")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "ESCUELA NORMAL PARA EDUCADORAS DE UNION DE TULA")
            put("turno_horario", "MATUTINO")
            put("nivel", "NORMALES")
            put("region", "SIERRA DE AMULA")
            put("municipio", "UNION DE TULA")
            put("localidad", "UNION DE TULA")
            put("domicilio", "AVENIDA MEXICO ORTE #345")
            put("codigo_postal", 48000)
            put("longitud", "104.515.42")
            put("latitud", "194.5741.17")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values10)


        val values11 = ContentValues().apply {
            put("clave_inmueble", "10PLJ33")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "INSTITUTO TECNOLOGICO SUPERIOR DE PUERTO VALLARTA")
            put("turno_horario", "MATUTINO")
            put("nivel", "SUPERIOR")
            put("region", "COSTA ORTE")
            put("municipio", "PUERTO VALLARTA")
            put("localidad", "PUERTO VALLARTA")
            put("domicilio", "COREA DEL SUR 600")
            put("codigo_postal", 48290)
            put("longitud", "105.611.07")
            put("latitud", "203.3918.18")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values11)




        val values12 = ContentValues().apply {
            put("clave_inmueble", "10PLJ34")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "ESCUELA NORMAL EXPERIMENTAL")
            put("turno_horario", "MATUTINO")
            put("nivel", "NORMALES")
            put("region", "VALLES")
            put("municipio", "AMECA")
            put("localidad", "SAN ANTONIO MATUTE")
            put("domicilio", "NINOS HEROES 13")
            put("codigo_postal", 46700)
            put("longitud", "103.657.48")
            put("latitud", "204.3348.61")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values12)



        val values13 = ContentValues().apply {
            put("clave_inmueble", "10PLJ35")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "SANTA QUITERIA")
            put("turno_horario", "MATUTINO")
            put("nivel", "PREESCOLAR")
            put("region", "VALLES")
            put("municipio", "EL ARENAL")
            put("localidad", "SANTA QUITERIA")
            put("domicilio", "RANCHO LA CANTERA. CALLE TRES CRUCES #600")
            put("codigo_postal", 45350)
            put("longitud", "103.540.65")
            put("latitud", "2034.2359.96")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values13)



        val values14 = ContentValues().apply {
            put("clave_inmueble", "10PLJ36")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "SANTA ANA DE ARRIBA")
            put("turno_horario", "MATUTINO")
            put("nivel", "PREESCOLAR")
            put("region", "ALTOS SUR")
            put("municipio", "SAN MIGUEL EL ALTO")
            put("localidad", "SANTA ANA DE ARRIBA")
            put("domicilio", "CONOCIDO SANTA ANA DE ARRIBA")
            put("codigo_postal", 47140)
            put("longitud", "-102.4180556")
            put("latitud", "21.095")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values14)


        val values15 = ContentValues().apply {
            put("clave_inmueble", "10PLJ37")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "SIN AGUA")
            put("turno_horario", "MATUTINO")
            put("nivel", "PREESCOLAR")
            put("region", "ALTOS SUR")
            put("municipio", "SAN MIGUEL EL ALTO")
            put("localidad", "SINAGUA")
            put("domicilio", "CONOCIDO SINAGUA")
            put("codigo_postal", 47140)
            put("longitud", "-102.1663333")
            put("latitud", "20.9760833")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values15)

        val values16 = ContentValues().apply {
            put("clave_inmueble", "10PLJ38")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "CANADA GRANDE")
            put("turno_horario", "MATUTINO")
            put("nivel", "PREESCOLAR")
            put("region", "SIERRA OCCIDENTAL")
            put("municipio", "CUAUTLA")
            put("localidad", "CAÑADA GRANDE")
            put("domicilio", "CONOCIDO")
            put("codigo_postal", 48150)
            put("longitud", "-104.3965667")
            put("latitud", "20.2572444")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values16)

        val values17 = ContentValues().apply {
            put("clave_inmueble", "10PLJ39")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "Francisco I Madero")
            put("turno_horario", "MATUTINO")
            put("nivel", "PREESCOLAR")
            put("region", "ALTOS ORTE")
            put("municipio", "Lagos de Moreno")
            put("localidad", "La Virgen")
            put("domicilio", "CONOCIDO")
            put("codigo_postal", 47400)
            put("longitud", "-101.9776167")
            put("latitud", "21.3616472")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values17)

        val values18 = ContentValues().apply {
            put("clave_inmueble", "10PLJ40")
            put("tecnologia_instalada", "iMAX")
            put("ancho_banda", "2 MB")
            put("institucion", "SEJ")
            put("nombre_centro", "Cocuasco")
            put("turno_horario", "MATUTINO")
            put("nivel", "Preescolar")
            put("region", "Norte")
            put("municipio", "Chimaltitán")
            put("localidad", "Cocuasco")
            put("domicilio", "CONOCIDO")
            put("codigo_postal", 46300)
            put("longitud", "103.138.48")
            put("latitud", "214504.03")
            put("estatus", "ACTIVO")
        }
        db.insert("datosconsultas", null, values18)



    }

    fun anyadirDato(clave_inmueble: String, tecnologia_instalada: String, ancho_banda: String, institucion: String,
                    nombre_centro: String, turno_horario: String, nivel: String, region: String, municipio: String,
                    localidad: String, domicilio: String, codigo_postal: Int, longitud: String,
                    latitud: String, estatus: String){
        val datos = ContentValues()
        datos.put("clave_inmueble", clave_inmueble)
        datos.put("tecnologia_instalada", tecnologia_instalada)
        datos.put("ancho_banda", ancho_banda)
        datos.put("institucion", institucion)
        datos.put("nombre_centro", nombre_centro)
        datos.put("turno_horario", turno_horario)
        datos.put("nivel", nivel)
        datos.put("region", region)
        datos.put("municipio", municipio)
        datos.put("localidad", localidad)
        datos.put("domicilio", domicilio)
        datos.put("codigo_postal", codigo_postal)
        datos.put("longitud", longitud)
        datos.put("latitud", latitud)
        datos.put("estatus", estatus)

        val db = this.writableDatabase
        db.insert("datosconsultas", null, datos)
        db.close()
    }

    fun borrarDato(clave_inmueble: String) : Int {
        val args = arrayOf(clave_inmueble)

        val db = this.writableDatabase
        val borrados = db.delete("datosconsultas", "clave_inmueble = ?", args)
        db.close()
        return borrados
    }

    fun ModificarDato(clave_inmueble: String, tecnologia_instalada: String, ancho_banda: String, institucion: String,
                    nombre_centro: String, turno_horario: String, nivel: String, region: String, municipio: String,
                    localidad: String, domicilio: String, codigo_postal: Int, longitud: String,
                    latitud: String, estatus: String){

        val args = arrayOf(clave_inmueble)
        val datos = ContentValues()

        datos.put("clave_inmueble", clave_inmueble)
        datos.put("tecnologia_instalada", tecnologia_instalada)
        datos.put("ancho_banda", ancho_banda)
        datos.put("institucion", institucion)
        datos.put("nombre_centro", nombre_centro)
        datos.put("turno_horario", turno_horario)
        datos.put("nivel", nivel)
        datos.put("region", region)
        datos.put("municipio", municipio)
        datos.put("localidad", localidad)
        datos.put("domicilio", domicilio)
        datos.put("codigo_postal", codigo_postal)
        datos.put("longitud", longitud)
        datos.put("latitud", latitud)
        datos.put("estatus", estatus)

        val db = this.writableDatabase
        db.update("datosconsultas", datos,"clave_inmueble = ?", args)
        db.close()
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS datosconsultas"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }
}