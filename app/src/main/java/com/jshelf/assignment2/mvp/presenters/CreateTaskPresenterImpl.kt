package com.jshelf.assignment2.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.customviewassignment.mvp.views.MainView
import com.jshelf.assignment2.mvp.views.CreateTaskView

class CreateTaskPresenterImpl:CreateTaskPresenter, ViewModel() {
    var mMainView: CreateTaskView? = null

    override fun initView(view: CreateTaskView) {
        mMainView=view
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapBack() {
        mMainView?.goToMain()
    }

}