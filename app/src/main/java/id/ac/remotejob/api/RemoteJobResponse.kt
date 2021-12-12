package id.ac.remotejob.api

import retrofit2.Call
import retrofit2.http.GET

interface RemoteJobResponse {

    @GET("remote-jobs")
    fun getRemoteJobResponse(): Call<RemoteJobResponse>
}