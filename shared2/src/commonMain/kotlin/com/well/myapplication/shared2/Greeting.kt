package com.well.myapplication.shared2


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
