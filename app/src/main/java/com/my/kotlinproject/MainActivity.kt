package com.my.kotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.my.kotlinproject.databinding.ActivityMainBinding

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil


class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var databinding: ActivityMainBinding

    // creating object of Presenter interface in Contract
    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        presenter = Presenter(this, Model())
        databinding.presenter=presenter
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    // method to display the Course Detail TextView
    override fun showProgress() {
        databinding.progressBar.visibility = View.VISIBLE
        databinding.textView.visibility = View.INVISIBLE
    }

    // method to hide the Course Detail TextView
    override fun hideProgress() {
        databinding.progressBar.visibility = View.GONE
        databinding.textView.visibility = View.VISIBLE
    }

    // method to set random string
    // in the Course Detail TextView
    override fun setString(string: String?) {
        databinding.textView.text = string
    }
}
