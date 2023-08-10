package com.example.cse225

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_external_storage.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class ExternalStorage : AppCompatActivity() {
    var filename =  "SampleFile.txt"
    lateinit var fstream:FileOutputStream
    val filepath = "Myfilestorage"
    lateinit var  myExternalFile: File
    var mPermission = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)
      save1.setOnClickListener {
          val username = """
          ${ET1.text}
          """.trimIndent()
          val password = ET2.text.toString()
          try {
              if (ContextCompat.checkSelfPermission(this,mPermission[0]) !=
                      PackageManager.PERMISSION_GRANTED
                  || ContextCompat.checkSelfPermission(this,mPermission[1]) !=
                      PackageManager.PERMISSION_GRANTED){
                  ActivityCompat.requestPermissions(this,mPermission,23)
              } else{
                  if(username.isEmpty() || password.isEmpty())
                      Toast.makeText(this,"either of field is empty",
                      Toast.LENGTH_LONG).show()
                  else{
                      myExternalFile = File(getExternalFilesDir(filepath),filename)
                      fstream = FileOutputStream(myExternalFile)
                      fstream.write(username.toByteArray())
                      fstream.write(password.toByteArray())
                      fstream.close()
                      Toast.makeText(applicationContext,"Details Saved in "+ myExternalFile!!.absolutePath,Toast.LENGTH_LONG).show()
                      intent = Intent(this,ExternalDetails::class.java)
                      startActivity(intent)
                  }
              }

          }
          catch (e:FileNotFoundException){
              e.printStackTrace()
          } catch (e:IOException){
              e.printStackTrace()
          }
      }

    }
}