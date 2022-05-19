package iguigui.biz

import iguigui.maak.MaaFactory

class MaakBusiness {

    var maaPath = ""

    var adbPath = ""

    val maaFactory by lazy {
        MaaFactory(maaPath, adbPath)
    }

}