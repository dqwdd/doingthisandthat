package com.example.testee33.network.api

data class Callback<out T>(val status: Status, var data: @UnsafeVariance T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Callback<T> {
            return Callback(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Callback<T> {
            return Callback(Status.ERROR, data, msg)
        }

        fun <T> loading(): Callback<T> {
            return Callback(Status.LOADING, null, null)
        }

        fun <T> empty(): Callback<T> {
            return Callback(Status.EMPTY, null, null)
        }
        fun <T> authFail(): Callback<T> {
            return Callback(Status.AUTHFAIL, null, null)
        }
    }

}