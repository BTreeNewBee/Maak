package iguigui.maak

import com.sun.jna.Pointer
import com.sun.jna.win32.StdCallLibrary

sealed interface MeoAssistant : StdCallLibrary {

    //第一步，加载资源
    fun AsstLoadResource(path: String): Boolean

    //选一个你喜欢的create，搞不定回调就用普通create
    fun AsstCreate(): Pointer

    fun AsstCreateEx(callback: AsstApiCallback, custom_arg: String): Pointer

    fun AsstDestroy(handle: Pointer)

    //连接安卓
    fun AsstConnect(handle: Pointer, adb: String, host: String, config: String): Boolean

    //添加任务链
    fun AsstAppendTask(handle: Pointer, type: String, params: String): Int

    //运行时修改参数
    fun AsstSetTaskParams(handle: Pointer, taskId: Int, params: String): Boolean

    //开跑！
    fun AsstStart(handle: Pointer): Boolean

    //爷不想跑了爷要自己玩
    fun AsstStop(handle: Pointer): Boolean

    //获取最后一次截图的内容，PNG格式编码
    fun AsstGetImage(handle: Pointer, buff: ByteArray, length: Long): Long

    //获取版本号
    fun AsstGetVersion(): String

    //向maa注入日志
    fun AsstLog(level: String, message: String)

    //回调接口，在后面实现
    interface AsstApiCallback : StdCallLibrary.StdCallCallback {
        /**
         * Return whether to continue enumeration.
         */
        fun callback(msg: Int, detail_json: String, custom_arg: Pointer)
    }

}