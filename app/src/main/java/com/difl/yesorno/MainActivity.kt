package com.difl.yesorno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.difl.yesorno.api.RetrofitInstance
import com.difl.yesorno.databinding.ActivityMainBinding
import com.difl.yesorno.model.RepositoryDataClass
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txt.setOnClickListener{
            get()
        }

        binding.imge.setOnClickListener{
            get()
        }

        get()

    }

    private fun get(){
        RetrofitInstance.apiInterface.getPost().enqueue(object : Callback<RepositoryDataClass?>{
            override fun onResponse(
                call: Call<RepositoryDataClass?>,
                response: Response<RepositoryDataClass?>
            ) {
                binding.txt.text = response.body()?.answer
                Glide.with(this@MainActivity).load(response.body()?.image).into(binding.imge)
            }

            override fun onFailure(call: Call<RepositoryDataClass?>, t: Throwable) {
               Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }

}