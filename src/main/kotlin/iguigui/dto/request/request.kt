package iguigui.dto.request

import iguigui.dto.STARTUP

sealed class BaseRequest(open val command: String)


data class StartUp(val data: String) : BaseRequest(STARTUP)