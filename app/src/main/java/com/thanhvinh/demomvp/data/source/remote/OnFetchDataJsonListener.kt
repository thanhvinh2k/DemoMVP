package com.thanhvinh.demomvp.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
