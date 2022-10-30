package com.jshelf.assignment2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jshelf.assignment2.R
import com.jshelf.assignment2.delegates.ProfileClickDelegate
import com.jshelf.assignment2.mvp.presenters.CreateTaskPresenter
import com.jshelf.assignment2.views.viewholder.ProfileViewHolder

class ProfileAdapter(private val mDelegate: ProfileClickDelegate) :
    RecyclerView.Adapter<ProfileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_profile_holder, parent, false
        )
        return ProfileViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return 3
    }
}