package com.alfsuace.patronobserver.commons
sealed class ErrorApp {
    object UnknownError: ErrorApp()
    object InternetError: ErrorApp()
    object DataError: ErrorApp()
}