package com.my.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.retrofit.databinding.ActivityMainBinding
import com.my.retrofit.network.APIClient
import com.my.retrofit.network.ApiInterface
import com.my.retrofit.network.DataModel
import com.my.retrofit.network.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var quotesList = ArrayList<DataModel>()
    private lateinit var databinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        getQuote()
    }
    private fun getQuote(){
        val client = APIClient().getRetrofitClient().create(ApiInterface::class.java)
        client.getQuotes().enqueue(object : Callback<ArrayList<DataModel>> {
            override fun onResponse(call: Call<ArrayList<DataModel>> ,response: Response<ArrayList<DataModel>>) {
            // Used for inserting data in arraylist of type DataModel
            quotesList = response.body()!!
            val adapter = RecyclerAdapter(quotesList)

            // For showing data list vertically

            databinding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            databinding.recyclerView.adapter = adapter

        }

            override fun onFailure(call: Call<ArrayList<DataModel>>, t: Throwable) {
            // Write a code for failure
        }

        })
    }
}