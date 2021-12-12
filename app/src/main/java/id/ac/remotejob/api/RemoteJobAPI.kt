package id.ac.remotejob.api

import id.ac.remotejob.models.RemoteJobResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteJobApi {

    @GET("remote-jobs?limit=20")
    fun getRemoteJobResponse(): Call<RemoteJobResponse>
}