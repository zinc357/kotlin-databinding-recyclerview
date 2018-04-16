package com.example.zinc.kotlinmvvmlist.viewmodel

import android.view.View
import com.example.zinc.kotlinmvvmlist.adapter.EmployeeAdapter
import com.example.zinc.kotlinmvvmlist.model.Employee

class EmployeeListViewModel(private val mEmployeeAdapter: EmployeeAdapter) {
    fun onClickAddItem(view: View) {
        mEmployeeAdapter.add(Employee("hah", "1", false))
    }

    fun onClickRemoveItem(view: View) {
        mEmployeeAdapter.remove()
    }

    fun onClickAddAll(view: View) {
        val demoList = ArrayList<Employee>()
        demoList.add(Employee("Zhai", "Mark", false))
        demoList.add(Employee("Zhai2", "Mark2", false))
        demoList.add(Employee("Zhai3", "Mark3", true))
        demoList.add(Employee("Zhai4", "Mark4", false))
        mEmployeeAdapter.addAll(demoList)
    }
}