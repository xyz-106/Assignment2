package com.jshelf.assignment2.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.jshelf.assignment2.R

class ProgressBar(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var size = 0
    var paint = Paint()
    var path = Path()
    var oval = RectF()
    var progress = 0
    var borderWidth = 10f
    var progressFrontColor = 0
    var progressBackColor = 0

    init {
        context?.withStyledAttributes(attrs, R.styleable.ProgressBar) {
            progress = getInt(R.styleable.ProgressBar_progressBarProgress, 0)
            progressBackColor = getColor(R.styleable.ProgressBar_progressBarBackgroundColor, 0)
            progressFrontColor = getColor(R.styleable.ProgressBar_progressBarFrontColor, 0)
            borderWidth = getDimension(R.styleable.ProgressBar_progressBarHeight, borderWidth)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.parseColor("#f58868")
        paint.style = Paint.Style.FILL
//        paint.textSize = size * 0.34f
        paint.strokeWidth = borderWidth
        var rectangle = RectF(0f, 0f, size.toFloat(), borderWidth / 2)
        path.addRoundRect(rectangle, 20f, 20f, Path.Direction.CCW)
        canvas?.clipPath(path)
        paint.color = progressBackColor
        canvas?.drawLine(size * 0.7f, 0f, size * 1f, 0f, paint)
        paint.color = progressFrontColor
        val newRectangle = RectF(0f, 0f, size * 0.8f, borderWidth / 2)
        canvas?.drawRoundRect(newRectangle, 20f, 20f, paint)


    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        size = w
    }


}