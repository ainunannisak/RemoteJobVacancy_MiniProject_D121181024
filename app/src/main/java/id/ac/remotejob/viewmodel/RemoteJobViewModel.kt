package id.ac.remotejob.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import id.ac.remotejob.repository.RemoteJobRepository

class RemoteJobViewModel(
    app: Application,
    private val remoteJobRepository: RemoteJobRepository): AndroidViewModel(app) {

       fun remoteJobResult() = remoteJobRepository.remoteJobResult()
}