package com.jshelf.assignment2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.mvp.presenters.MainPresenter
import com.example.customviewassignment.mvp.views.MainView
import com.jshelf.assignment2.R
import com.jshelf.assignment2.adapters.ProfileAdapter
import com.jshelf.assignment2.mvp.presenters.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_new_task.*

class NewTask : AppCompatActivity(), MainView {
    lateinit var profileAdapter: ProfileAdapter
    lateinit var mPresenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        setUpPresenter()
        setUpView()
    }

    private fun setUpView() {
        profileAdapter = ProfileAdapter(mPresenter)
        rvProfile3.addItemDecoration(MyItemDecoration())
        rvProfile3.adapter = profileAdapter
        rvProfile3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        backButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.iniView(this)
    }

    override fun goToProfile() {

    }


}