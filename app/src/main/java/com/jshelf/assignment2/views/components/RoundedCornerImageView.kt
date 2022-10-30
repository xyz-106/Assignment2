package com.jshelf.assignment2.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.jshelf.assignment2.R

class RoundedCornerImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.WHITE

        private const val DEFAULT_BORDER_WIDTH = 5.0f
    }

    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var size = 0
    private var cornerRadius = 0f

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }


    private fun setupAttributes(attrs: AttributeSet?) {

        context.withStyledAttributes(attrs, R.styleable.RoundedCornerImageView) {
            cornerRadius = getDimension(R.styleable.RoundedCornerImageView_cornerRadius, 0f)
            borderColor = getColor(
                R.styleable.RoundedCornerImageView_borderColor, DEFAULT_BORDER_COLOR
            )
            borderWidth = getDimension(
                R.styleable.RoundedCornerImageView_borderWidth, DEFAULT_BORDER_WIDTH
            )
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = measuredWidth.coerceAtMost(measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {

        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)
        canvas?.clipPath(path)

        val radius = size / 2f

        paint.color = borderColor
        paint.style = Paint.Style.FILL
        //canvas.drawCircle(size / 2f, size / 2f, radius, paint)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        super.onDraw(canvas)
        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)

    }


}