// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arpit/Desktop/ArpitPlayTest/testapp/conf/routes
// @DATE:Sun Jun 10 14:04:19 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getSms(from:String = null, to:String = null, text:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "inbound/sms" + play.core.routing.queryString(List(if(from == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("from", from)), if(to == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("to", to)), if(text == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("text", text)))))
    }
  
    // @LINE:8
    def outboundSms(ffrom:String = null, to:String = null, text:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "outbound/sms" + play.core.routing.queryString(List(if(ffrom == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("ffrom", ffrom)), if(to == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("to", to)), if(text == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("text", text)))))
    }
  
    // @LINE:9
    def getToken(username:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "sms/getToken" + play.core.routing.queryString(List(if(username == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("username", username)))))
    }
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
