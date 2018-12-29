package ir.sharif.vamdeh.webservices.webservices.userRecord

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ir.sharif.vamdeh.webservices.base.requestProcess.BaseResponse

class RecordResponse: BaseResponse(){
    @SerializedName("coins")
    @Expose
    var coins: Int = 0

    @SerializedName("gem")
    @Expose
    var gem: Int = 0

    @SerializedName("avatar")
    @Expose
    var avatar: Int = 0

    @SerializedName("level")
    @Expose
    var level: Int = 0

}