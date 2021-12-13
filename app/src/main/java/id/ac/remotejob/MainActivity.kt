package id.ac.remotejob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.ac.remotejob.databinding.ActivityMainBinding
import id.ac.remotejob.repository.RemoteJobRepository
import id.ac.remotejob.viewmodel.RemoteJobViewModel
import id.ac.remotejob.viewmodel.RemoteJobViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: RemoteJobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel(){
        val remoteJobRepository = RemoteJobRepository()

        val viewModelProviderFactory = RemoteJobViewModelFactory(
            application,
            remoteJobRepository
        )

        viewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        ).get(RemoteJobViewModel::class.java)
    }
}