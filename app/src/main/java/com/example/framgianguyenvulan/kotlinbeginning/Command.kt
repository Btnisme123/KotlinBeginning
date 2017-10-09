package com.example.framgianguyenvulan.kotlinbeginning

/**
 * Created by FRAMGIA\nguyen.vu.lan on 09/10/2017.
 */
public interface  Command<out T>{
    fun excute():T
}