package com.example.customviewassignment.mvp.presenters

import com.example.customviewassignment.mvp.views.MainView
import com.jshelf.assignment2.delegates.ProfileClickDelegate

interface MainPresenter : IBasePresenter, ProfileClickDelegate {

    fun iniView(view: MainView)
}