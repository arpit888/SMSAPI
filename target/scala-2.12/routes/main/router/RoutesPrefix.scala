// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arpit/Desktop/ArpitPlayTest/testapp/conf/routes
// @DATE:Sun Jun 10 14:04:19 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
