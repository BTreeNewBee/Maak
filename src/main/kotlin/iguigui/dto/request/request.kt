package iguigui.dto.request

import iguigui.dto.APPEND_TASK
import iguigui.dto.CONNECT
import iguigui.dto.LIST_INSTANCE
import iguigui.dto.STARTUP
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


sealed class BaseRequest

@Serializable
sealed class DataContent

@Serializable
sealed class AppendTaskContent: DataContent()


@Serializable
data class AppendTaskStartUpContent(val ): DataContent()

@Serializable
data class ConnectContent(val adb: String,val host: String, val config: String) : DataContent()

@Serializable
object EmptyContent : DataContent()

@Serializable
@SerialName(LIST_INSTANCE)
data class ListInstanceRequst(val data: DataContent) : BaseRequest()


@Serializable
@SerialName(CONNECT)
data class Connect(val data: ConnectContent) : BaseRequest()

@Serializable
@SerialName(APPEND_TASK)
data class AppendTask(val data: ConnectContent) : BaseRequest()

