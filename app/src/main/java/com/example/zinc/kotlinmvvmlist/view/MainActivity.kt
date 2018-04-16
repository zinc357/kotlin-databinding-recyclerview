package com.example.zinc.kotlinmvvmlist.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.zinc.kotlinmvvmlist.R
import com.example.zinc.kotlinmvvmlist.adapter.EmployeeAdapter
import com.example.zinc.kotlinmvvmlist.databinding.ActivityMainBinding
import com.example.zinc.kotlinmvvmlist.model.Employee2
import com.example.zinc.kotlinmvvmlist.viewmodel.EmployeeListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    lateinit var mEmployeeAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        mBinding.presenter = Presenter()

        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mEmployeeAdapter = EmployeeAdapter(this)
        mBinding.recyclerView.adapter = mEmployeeAdapter
        mEmployeeAdapter.setListener(object : EmployeeAdapter.OnItemClickListener {
            override fun onEmployeeClick(employee: Employee2) {
                Toast.makeText(this@MainActivity,
                        employee.firstName, Toast.LENGTH_SHORT).show()
            }
        })

        mBinding.listvm = EmployeeListViewModel(mEmployeeAdapter)
    }
}
