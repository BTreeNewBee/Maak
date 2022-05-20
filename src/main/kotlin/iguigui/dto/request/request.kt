package iguigui.dto.request

import iguigui.dto.LIST_INSTANCE
import iguigui.dto.STARTUP
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


sealed class BaseRequest


@Serializable
@SerialName(STARTUP)
data class StartUpRequst(val data: String) : BaseRequest()

@Serializable
@SerialName(LIST_INSTANCE)
data class ListInstanceRequst(val data: String) : BaseRequest()