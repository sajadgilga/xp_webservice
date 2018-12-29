package ir.sharif.vamdeh.webservices.pref

import android.content.Context
import android.content.SharedPreferences

class WebservicePrefSetting private constructor(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PrefCostance.SHARED_NAME, Context.MODE_PRIVATE)

    var isRegister: Boolean
        get() = sharedPreferences.getBoolean(PrefCostance.IS_REGISTER, false)
        set(register) = sharedPreferences.edit().putBoolean(PrefCostance.IS_REGISTER, register).apply()

    val token: String
        get() = sharedPreferences.getString(PrefCostance.SHARED_KEY, "")

    fun saveToken(key: String) {
        sharedPreferences.edit().putString(PrefCostance.SHARED_KEY, key).apply()

    }

    companion object {

        private var instance: WebservicePrefSetting? = null

        fun getInstance(context: Context): WebservicePrefSetting? {
            if (instance == null) {
                instance = WebservicePrefSetting(context)
            }
            return instance
        }

        val instanceWithoutContext: WebservicePrefSetting?
            get() {
                if (instance == null) {
                    throw RuntimeException("Please set context first")
                }
                return instance
            }
    }
}
