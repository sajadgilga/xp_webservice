package ir.sharif.vamdeh.webservices

import android.content.Context
import ir.sharif.vamdeh.webservices.base.LoginType

import java.io.IOException

import ir.sharif.vamdeh.webservices.base.WebserviceException
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting
import ir.sharif.vamdeh.webservices.webservices.login.LoginProcess
import ir.sharif.vamdeh.webservices.webservices.login.LoginResponse
import ir.sharif.vamdeh.webservices.webservices.userRecord.RecordProcess
import ir.sharif.vamdeh.webservices.webservices.userRecord.RecordResponse

object WebserviceHelper {
    @Throws(IOException::class, WebserviceException::class)
    fun login(context: Context, type: LoginType): LoginResponse {
        val process = LoginProcess(type)
        val response = process.process()
        WebservicePrefSetting.getInstance(context)!!.saveToken(response.token)
        return response
    }

    @Throws(IOException::class, WebserviceException::class)
    fun record(): RecordResponse{
        val process = RecordProcess()
        return process.process()
    }
}
