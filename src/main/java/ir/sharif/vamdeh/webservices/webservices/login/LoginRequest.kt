package ir.sharif.vamdeh.webservices.webservices.login

import com.google.gson.annotations.SerializedName

import ir.sharif.vamdeh.webservices.base.requestProcess.BaseRequest
import ir.sharif.vamdeh.webservices.base.LoginType

class LoginRequest(@field:SerializedName("type")
                   private val type: LoginType) : BaseRequest()
