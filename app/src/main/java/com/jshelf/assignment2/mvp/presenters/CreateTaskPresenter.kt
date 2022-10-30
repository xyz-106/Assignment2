package com.jshelf.assignment2.mvp.presenters

import com.example.customviewassignment.mvp.presenters.IBasePresenter
import com.jshelf.assignment2.delegates.BackDelegate
import com.jshelf.assignment2.mvp.views.CreateTaskView

interface CreateTaskPresenter: IBasePresenter, BackDelegate {
    fun initView(view:CreateTaskView)
}