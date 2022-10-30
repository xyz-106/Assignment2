package com.jshelf.assignment2.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.jshelf.assignment2.R

class CircularProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var borderColor1 = Color.YELLOW
    private var borderWidth1 = 4.0f
    private var size = 0

    // To draw mouth on a path
    private val mouthPath = Path()

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {

        // get custom attribute values from xml
        context.withStyledAttributes(attrs, R.styleable.CircularProgressBar) {

//            borderColor1 = getColor(R.styleable.CircularProgressBar_circleColor, Color.YELLOW)
//              getDimension(R.styleable.CircularProgressBar_circleBorderWidth, 2.0f)
        }
    }

    override fun onDraw(canvas: Canvas) {
        // call the super method to keep any drawing from the parent side.
        drawProgressBar(canvas)
        super.onDraw(canvas)

    }

    private fun drawProgressBar(canvas: Canvas) {
        val rect = RectF(10f, 10f, width.toFloat() - 10f, height.toFloat() - 10f)
        val paint = Paint()
        paint.apply {
            strokeWidth = 10.0f
            style = Paint.Style.STROKE
            color = Color.parseColor("#FF9800")
        }
        canvas.drawArc(rect, 270f, 270f, false, paint)
        paint.apply {
            strokeWidth = 10.0f
            style = Paint.Style.STROKE
            color = Color.parseColor("#B3ACAC")
        }
        canvas.drawArc(rect, 180f, 90f, false, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 1 get minimum value
        size = measuredWidth.coerceAtMost(measuredHeight)

        // 2 override width and height
        setMeasuredDimension(size, size)
    }
}