package com.example.testee33

import android.content.Context

interface ResourceProvider {
    fun getString(resId:Int) : String
}

class ResourceProviderImpl(private val context:Context) : ResourceProvider {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }
}


