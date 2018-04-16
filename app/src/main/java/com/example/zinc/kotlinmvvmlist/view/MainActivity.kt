package com.example.zinc.kotlinmvvmlist.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.zinc.kotlinmvvmlist.model.Employee
import com.example.zinc.kotlinmvvmlist.EmployeeAdapter
import com.example.zinc.kotlinmvvmlist.R
import com.example.zinc.kotlinmvvmlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    lateinit var mEmployeeAdapter: EmployeeAdapter

    inner class Presenter {
        fun onClickAddItem(view: View) {
            mEmployeeAdapter.add(Employee("hah", "1", false))
        }

        fun onClickRemoveItem(view: View) {
            mEmployeeAdapter.remove()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.presenter = Presenter()

        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mEmployeeAdapter = EmployeeAdapter(this)
        mBinding.recyclerView.adapter = mEmployeeAdapter
        mEmployeeAdapter.setListener(object : EmployeeAdapter.OnItemClickListener {
            override fun onEmployeeClick(employee: Employee) {
                Toast.makeText(this@MainActivity,
                        employee.firstName, Toast.LENGTH_SHORT).show()
            }
        })

        val demoList = ArrayList<Employee>()
        demoList.add(Employee("Zhai", "Mark", false))
        demoList.add(Employee("Zhai2", "Mark2", false))
        demoList.add(Employee("Zhai3", "Mark3", true))
        demoList.add(Employee("Zhai4", "Mark4", false))
        mEmployeeAdapter.addAll(demoList)
    }
}
