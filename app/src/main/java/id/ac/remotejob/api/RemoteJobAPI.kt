package id.ac.remotejob.api

import id.ac.remotejob.models.RemoteJobResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteJobApi {
    //GET data from api with limit
    @GET("remote-jobs?limit=8")
    fun getRemoteJobResponse(): Call<RemoteJobResponse>
}