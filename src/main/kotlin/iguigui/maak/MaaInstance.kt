package iguigui.maak

import com.sun.jna.Pointer
import iguigui.maak.MeoAssistant.AsstApiCallback

class MaaInstance(val instance: MeoAssistant, val id: String): AsstApiCallback {

    constructor(instance: MeoAssistant, pointer: Pointer, id: String) : this(instance, id) {
        this.pointer = pointer
    }

    lateinit var pointer: Pointer

    override fun callback(msg: Int, detail_json: String, custom_arg: Pointer) {

    }

}