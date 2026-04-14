package sv.edu.retrofitdogapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sv.edu.retrofitdogapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    // Usamos lateinit para evitar el uso excesivo de '!!' o '?'
    private lateinit var binding: ActivityMainBinding
    private lateinit var dogAdapter: DogAdapter
    private var images: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        binding.searchDogs.setOnQueryTextListener(this)
    }

    private fun initRecyclerView() {
        dogAdapter = DogAdapter(images)
        binding.listDogs.layoutManager = LinearLayoutManager(this)
        binding.listDogs.adapter = dogAdapter
    }

    private fun getRetrofit(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun searchByName(raza: String) {
        val batch = getRetrofit().getDogsByBreed(raza)

        // Corregimos la nulidad en el Callback para eliminar los Warnings
        batch?.enqueue(object : Callback<DogsResponse?> {
            override fun onResponse(call: Call<DogsResponse?>, response: Response<DogsResponse?>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    // Obtenemos las imágenes filtrando posibles nulos por seguridad
                    val responseImages = responseBody.getImages()?.filterNotNull() ?: emptyList()

                    images.clear()
                    images.addAll(responseImages)
                    dogAdapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }

            override fun onFailure(call: Call<DogsResponse?>, t: Throwable) {
                showError()
            }
        })
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error al buscar la raza", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            searchByName(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean = true
}