package ifsp.dmos5.datastoreexemplo.ui.main

import android.os.Bundle
import android.text.Editable.Factory
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ifsp.dmos5.datastoreexemplo.R
import ifsp.dmos5.datastoreexemplo.data.repository.UserRepository
import ifsp.dmos5.datastoreexemplo.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Instanciar a viewModel usando a Factory
        val repository = UserRepository(applicationContext) //não passar o this
        val myFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, myFactory)
            .get(MainViewModel::class.java)

        setupObservers()
        setupListeners()


    }

    private fun setupListeners(){
        binding.buttonSave.setOnClickListener{
            val str = binding.editName.text.toString()
            viewModel.save(str)
        }
    }

    private fun setupObservers(){
        lifecycleScope.launch {
            viewModel.username.collect{
                if(it.isNullOrBlank()){
                    binding.textmesage.text = "Bem vindo, usuário !"
                    binding.buttonSave.text = "salvar"
                }else{
                    binding.textmesage.text = "Bem vindo de volta, $it !"
                    binding.buttonSave.text = "alterar"
                }
            }
        }
    }
}

