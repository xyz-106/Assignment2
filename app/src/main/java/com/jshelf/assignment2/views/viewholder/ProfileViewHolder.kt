package com.jshelf.assignment2.views.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jshelf.assignment2.delegates.ProfileClickDelegate
import com.jshelf.assignment2.mvp.presenters.CreateTaskPresenter
import kotlinx.android.synthetic.main.activity_profile_holder.view.*

class ProfileViewHolder(itemView: View, mDelegate: ProfileClickDelegate) :
    RecyclerView.ViewHolder(itemView) {
    init {
        itemView.profileImg.setOnClickListener {
            mDelegate.onTapProfile()
        }
    }
}