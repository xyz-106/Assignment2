package com.jshelf.assignment2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jshelf.assignment2.R
import com.jshelf.assignment2.views.viewholder.ImageViewHolder

class ImageCircleAdapter() : RecyclerView.Adapter<ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.circle_holder, parent, false
        )
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return 3
    }
}