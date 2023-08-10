package com.example.cse225

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_shared_prefrences_img.*
import java.io.ByteArrayOutputStream

class SharedPrefrencesIMG : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefrences_img)

        save.setOnClickListener {
            saveImage(imageView7,this)
        }
        show.setOnClickListener {
            loadLastImage(imageView8,this)
        }
    }
   private fun saveImage(imageView: ImageView, context: Context){
        val sharedPref = context.getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
       val bays= ByteArrayOutputStream()
        val bitmap = imageView.drawable.toBitmap()
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bays)
        val encodedImage = Base64.encodeToString(bays.toByteArray(),Base64.DEFAULT)
        with(sharedPref.edit()){
            putString("encodedImage",encodedImage)
            apply()
        }

    }
    private fun loadLastImage(imageView: ImageView, context: Context){
        val sharedPref = context.getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        val encodedImage = sharedPref.getString("encodedImage","Default")
        if(encodedImage != "DEFAULT"){
            val imageBytes = Base64.decode(encodedImage,Base64.DEFAULT)
            val decodedImage  = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.size)
            imageView.setImageBitmap(decodedImage)
        }
    }

}