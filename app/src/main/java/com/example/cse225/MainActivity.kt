package com.example.cse225
import android.annotation.SuppressLint
import android.app.DownloadManager.Request
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI
//lateinit var filepath: Uri

class MainActivity : AppCompatActivity() {
    val del = 123
    @SuppressLint("MissingInflatedid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ip = registerForActivityResult(ActivityResultContracts.GetContent())
        {
          //  filepath = it!!
            imageView2.setImageURI(it)
        }

        button5.setOnClickListener() {
            ip.launch("image/*")
        }

        button6.setOnClickListener {
            val i=if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.CUPCAKE)
            {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            }

            else
            {
            }
            startActivityForResult(i as Intent?,del)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==del){
            var b=data?.extras!!["data"] as Bitmap
            imageView2.setImageBitmap(b)
        }

    }
}
