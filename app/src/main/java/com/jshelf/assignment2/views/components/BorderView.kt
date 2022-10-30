//package com.jshelf.assignment2.views.components
//
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.Path
//import android.util.AttributeSet
//import android.view.View
//import androidx.core.content.withStyledAttributes
//import com.jshelf.assignment2.R
//
//class BorderView(context: Context, attrs: AttributeSet) : View(context, attrs) {
//    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
//
//    companion object {
//        const val DEFAULT_BORDER_COLOR = Color.WHITE
//
//        const val DEFAULT_BORDER_WIDTH = 10.0f
//    }
//
//    private var borderColor = DEFAULT_BORDER_COLOR
//    private var borderWidth = DEFAULT_BORDER_WIDTH
//    private var size = 0
//    private val mouthPath = Path()
//
//    init {
//        paint.isAntiAlias = true
//        setupAttributes(attrs)
//    }
//
//    private fun setupAttributes(attrs: AttributeSet?) {
//
//        context.withStyledAttributes(attrs, R.styleable.RoundedCornerImageView) {
//            borderColor =
//                getColor(R.styleable.RoundedCornerImageView_borderColor, DEFAULT_BORDER_COLOR)
//            borderWidth =
//                getDimension(R.styleable.RoundedCornerImageView_borderWidth, DEFAULT_BORDER_WIDTH)
//        }
//    }
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        drawFaceBackground(canvas)
//
//    }
//
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        size = measuredWidth.coerceAtMost(measuredHeight)
//        setMeasuredDimension(size, size)
//    }
//
//
//    private fun drawFaceBackground(canvas: Canvas) {
//        val radius = size / 2f
//
//        paint.color = borderColor
//        paint.style = Paint.Style.FILL
//        //canvas.drawCircle(size / 2f, size / 2f, radius, paint)
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = borderWidth
//
//        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
//
//    }
//}