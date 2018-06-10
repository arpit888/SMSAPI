// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arpit/Desktop/ArpitPlayTest/testapp/conf/routes
// @DATE:Sun Jun 10 14:04:19 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getSms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getSms",
      """
        function(from0,to1,text2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inbound/sms" + _qS([(from0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("from", from0)), (to1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("to", to1)), (text2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("text", text2))])})
        }
      """
    )
  
    // @LINE:8
    def outboundSms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outboundSms",
      """
        function(ffrom0,to1,text2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "outbound/sms" + _qS([(ffrom0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("ffrom", ffrom0)), (to1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("to", to1)), (text2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("text", text2))])})
        }
      """
    )
  
    // @LINE:9
    def getToken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getToken",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sms/getToken" + _qS([(username0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("username", username0))])})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
