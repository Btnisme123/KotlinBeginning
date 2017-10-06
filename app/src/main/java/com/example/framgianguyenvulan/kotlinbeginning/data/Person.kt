package com.example.framgianguyenvulan.kotlinbeginning.data

/**
 * Created by FRAMGIA\nguyen.vu.lan on 06/10/2017.
 */

class Person {
    var name:String=""
    get()=field.toUpperCase()
    set(value){
        field="Name:$value"
    }
}
