package iguigui.maak

import com.sun.jna.Native
import java.util.UUID

class MaaFactory(val maaPath: String, val adbPath: String) {

    val instance: MeoAssistant

    init {
        instance = Native.load("MeoAssistant", MeoAssistant::class.java)
        instance.AsstLoadResource(maaPath)
    }

    fun create() = MaaInstance(instance, instance.AsstCreate(), generatorId())

    fun createEx() = run {
        val maaInstance = MaaInstance(instance, generatorId())
        maaInstance.pointer = instance.AsstCreateEx(maaInstance, maaInstance.id)
    }


    private fun generatorId() = UUID.randomUUID().toString()
}