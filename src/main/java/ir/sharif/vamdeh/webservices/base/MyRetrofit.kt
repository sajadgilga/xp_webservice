package ir.sharif.vamdeh.webservices.base

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting

import ir.sharif.vamdeh.webservices.base.WebserviceAdresses.BASE_URL

class MyRetrofit {

    private var urls: WebserviceUrls? = null

    val webserviceUrls: WebserviceUrls?
        get() {
            if (urls == null) {
                urls = getUrls()
            }
            return urls
        }

    private val token: String
        get() {
            val key = WebservicePrefSetting.instanceWithoutContext!!.token
            return "token $key"
        }


    private fun getUrls(): WebserviceUrls {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val builder = OkHttpClient.Builder()

        addLogginInterceptor(builder)
        addAuthHeader(builder)

        val client = builder.build()


        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        return retrofit.create(WebserviceUrls::class.java)
    }

    private fun addLogginInterceptor(client: OkHttpClient.Builder) {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(interceptor)
    }

    private fun addAuthHeader(client: OkHttpClient.Builder) {
        if (WebservicePrefSetting.instanceWithoutContext!!.isRegister) {
            client.addInterceptor { chain ->
                val original = chain.request()

                val request = original.newBuilder()

                        .addHeader("Authorization", "JWT $token")
                        .build()

                chain.proceed(request)
            }
        }
    }

    companion object {

        var instance: MyRetrofit? = null
            get() {
                if (field == null) instance = MyRetrofit()
                return field
            }
    }
}
