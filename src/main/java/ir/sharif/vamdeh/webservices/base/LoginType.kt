package ir.sharif.vamdeh.webservices.base

enum class LoginType(val type: String) {
    GUEST("guest"),
    GOOGLE("google-oauth2"),
    FACEBOOK("facebook")
}