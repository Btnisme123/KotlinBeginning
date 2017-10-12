package com.example.framgianguyenvulan.kotlinbeginning.delegate

import kotlin.reflect.KProperty

/**
 * Created by FRAMGIA\nguyen.vu.lan on 12/10/2017.
 */
object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValue<T>()

    class NotNullSingleValue<T> {
        private var value: T? = null
        operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
                value ?: throw IllegalStateException("$(property.name) not initilized")

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = if (this.value == null) value
            else throw IllegalStateException("$(property.name) not initilized")
        }
    }
}