package com.example.cse225

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration

private const val STROKE_WIDTH = 12F

class TouchDemo(context: Context): View(context) {
    private var path = Path()
    private val drawColor = Color.CYAN
    private val backgroundColor = Color.BLACK
    private lateinit var  extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private lateinit var frame: Rect
    private val paint = Paint().apply {
        color = drawColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeWidth = STROKE_WIDTH
    }
    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop
    private var currentX = 0f
    private var currentY = 0f
    private var motionTouchEventX = 0f
    private var motionTouchEventY = 0f
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if(::extraBitmap.isInitialized)extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
        val inset = 40
        frame = Rect(inset,inset,w-inset,h-inset)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(extraBitmap,0f,0f,null)
        extraCanvas.drawRect(frame,paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        motionTouchEventX = event!!.x
        motionTouchEventY = event.y
        when(event.action){
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }
    private  fun touchStart() {
        path.reset()
        path.moveTo(motionTouchEventX,motionTouchEventY)
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }
    private fun touchMove(){
        val dx = Math.abs(motionTouchEventX - currentX)
        val dy = Math.abs(motionTouchEventY - currentY)
        if(dx >= touchTolerance || dy >= touchTolerance){
            path.quadTo(
                currentX,
                currentY,
                (motionTouchEventX + currentX)/2,
                (motionTouchEventY + currentY)/2
            )
            currentX = motionTouchEventX
            currentY = motionTouchEventY
            extraCanvas.drawPath(path,paint)
        }
        invalidate()
    }
    private fun touchUp(){
        path.reset()
    }
}