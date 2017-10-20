package com.example.framgianguyenvulan.kotlinbeginning.extensions

import android.content.Context
import kotlin.reflect.KProperty

object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?: throw IllegalStateException("${property.name} not initialized")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }

    class LongPreference(val context: Context, val name: String, val default: Long) {
        val prefs by lazy {
            context.getSharedPreferences("default", Context.MODE_PRIVATE)
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
            return prefs.getLong(name, default)
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
            prefs.edit().putLong(name, value).apply()
        }
    }
}