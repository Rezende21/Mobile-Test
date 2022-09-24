package com.example.mobiletest.state

sealed class ResourceState<T>(val data : T? = null,
                              val message : String? = null) {
    class Success<T>(data: T) : ResourceState<T>(data)
    class Error<T>(message: String, data: T? = null) : ResourceState<T>(data, message)
    class Loading<T> : ResourceState<T>()
    class Empty<T>: ResourceState<T>()

}