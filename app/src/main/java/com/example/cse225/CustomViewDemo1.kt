package com.example.cse225

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.io.path.Path

class CustomViewDemo1(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint =Paint(Paint.ANTI_ALIAS_FLAG)
    var circleColor= Color.CYAN
    var borderColor=Color.BLACK
    var borderSize=5.0f
    private var eyesColor = Color.BLACK
    private  var mouthColor = Color.BLACK
    private var mouthPath = Path()
    var size=420

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCircle(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }
    fun drawCircle(c:Canvas?)
    {
        paint.color=circleColor
        val radius=size/2f
        c?.drawCircle(size/2f,size/2f,radius, paint)
        paint.color=borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth=borderSize
        c?.drawCircle(size/2f,size/2f,radius-borderSize/2f, paint)
    }

    fun drawEyes(c:Canvas?)
    {
        paint.color=eyesColor
        paint.style=Paint.Style.FILL
        val left= RectF(size*0.30f,size*0.23f,size*0.43f,size*0.50f)
        val right= RectF(size*0.55f,size*0.23f,size*0.68f,size*0.50f)
        c?.drawOval(left,paint)
        c?.drawOval(right,paint)

    }
    fun drawMouth(c: Canvas?)
    {
        paint.color=mouthColor
        paint.style=Paint.Style.FILL
        mouthPath.moveTo(size*0.22f,size*0.7f)
        mouthPath.quadTo(size*0.50f,size*0.50f,size*0.22f,size*0.70f)
        mouthPath.quadTo(size*0.50f,size*0.60f,size*0.78f,size*0.70f)
        c?.drawPath(mouthPath,paint)

    }

}