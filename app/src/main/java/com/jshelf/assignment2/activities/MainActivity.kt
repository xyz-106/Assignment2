package com.jshelf.assignment2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.mvp.presenters.MainPresenter
import com.example.customviewassignment.mvp.views.MainView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jshelf.assignment2.R
import com.jshelf.assignment2.adapters.EmployeeListAdapter
import com.jshelf.assignment2.adapters.ImageCircleAdapter
import com.jshelf.assignment2.adapters.ProfileAdapter
import com.jshelf.assignment2.mvp.presenters.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*

class MainActivity : AppCompatActivity(), MainView {
    lateinit var profileAdapter: ProfileAdapter
    lateinit var circleImageAdapter: ImageCircleAdapter
    lateinit var employeeAdapter: EmployeeListAdapter
    lateinit var mPresenter: MainPresenter
    val empTab = listOf("Project Tasks", "Contacts", "About you")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpGenreTabLayout()
        setUpView()
        setUpListener()

    }

    private fun setUpListener() {
        plusIcon.setOnClickListener{
            val intent = Intent(this, NewTask::class.java)
            startActivity(intent)
        }
    }


    private fun setUpGenreTabLayout() {
        empTab.forEach {
            val tab = tbProfile.newTab()
            tab.text = it
            tbProfile.addTab(tab)
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.iniView(this)
    }

    private fun setUpView() {
        profileAdapter = ProfileAdapter(mPresenter)
        rvProfile.addItemDecoration(MyItemDecoration())
        rvProfile.adapter = profileAdapter
        rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        circleImageAdapter = ImageCircleAdapter()
        rvCircleLine.adapter = circleImageAdapter
        rvCircleLine.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        employeeAdapter = EmployeeListAdapter()
        rvEmployee.adapter = employeeAdapter
        rvEmployee.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        rvProfile2.adapter = employeeAdapter
        rvProfile2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun goToProfile() {

        val sheet = BottomSheetBehavior.from(bottomSheetMain)
        btnClose.setOnClickListener {
            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        when {
            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }

    }
}