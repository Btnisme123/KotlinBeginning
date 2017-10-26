package com.example.framgianguyenvulan.kotlinbeginning.ExtraConcept.Enum

import com.example.framgianguyenvulan.kotlinbeginning.R

/**
 * Created by FRAMGIA\nguyen.vu.lan on 10/26/17.
 */
enum class Icon(val res: Int) {
    UP(R.mipmap.ic_launcher),
    DOWN(R.mipmap.ic_launcher_round)
}

val downIcon = Icon.DOWN.res
val stringIcon: Icon = Icon.valueOf("DOWN")
val iconList: Array<Icon> = Icon.values()
val upName: String = Icon.UP.name
val upPosition:Int=Icon.UP.ordinal