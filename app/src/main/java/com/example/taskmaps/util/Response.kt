package com.example.taskmaps.util

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        // Creates a Resource object with a SUCCESS status and some data.
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        // Creates a Resource object with an ERROR status and an error message.
        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        // Creates a Resource object with a LOADING status to notify the UI.
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}



enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}