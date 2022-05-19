
import iguigui.server.WsServer


//试图给Maa编写一个WS接口这样子我就可以集成机器人上了
fun main(args: Array<String>) {
    var port = 8848
    try {
        port = args[0].toInt()
    } catch (ex: Exception) { }
    val s = WsServer(port)
    s.start()
    println("ChatServer started on port: " + s.port)
}