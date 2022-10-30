package com.jshelf.assignment2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jshelf.assignment2.R
import com.jshelf.assignment2.views.viewholder.EmployeeViewHolder

class EmployeeListAdapter() : RecyclerView.Adapter<EmployeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_employee_holder, parent, false
        )
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int {

        return 10
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

    }
}