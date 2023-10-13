package com.difl.yesorno

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.difl.yesorno.api.RetrofitInstance
import com.difl.yesorno.databinding.ActivityMainBinding
import com.difl.yesorno.model.RepositoryDataClass
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
            binding.txt.text = "Thinking..."
            get()
        }

        binding.imge.setOnClickListener{
            binding.txt.text = "Thinking..."
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
                Glide.with(this@MainActivity).load(response.body()?.image).into(binding.imge)

                if(response.body()?.answer.toString().equals("no")){
                    binding.txt.text = response.body()?.answer
                }
                else if(response.body()?.answer.toString().equals("yes")){
                    binding.txt.text = response.body()?.answer
                }
                else{
                    binding.txt.text = response.body()?.answer
                }

            }

            override fun onFailure(call: Call<RepositoryDataClass?>, t: Throwable) {
               Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }

}