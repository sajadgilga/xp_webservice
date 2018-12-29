package ir.sharif.vamdeh.webservices.base

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import ir.sharif.vamdeh.webservices.webservices.login.LoginRequest
import ir.sharif.vamdeh.webservices.webservices.login.LoginResponse
import ir.sharif.vamdeh.webservices.webservices.userRecord.RecordProcess
import ir.sharif.vamdeh.webservices.webservices.userRecord.RecordResponse
import retrofit2.http.POST

interface WebserviceUrls {
    @POST(WebserviceAdresses.LOGIN)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET(WebserviceAdresses.RECORD)
    fun record(): Call<RecordResponse>
}
