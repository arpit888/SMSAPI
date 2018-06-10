// @GENERATOR:play-routes-compiler
// @SOURCE:/home/arpit/Desktop/ArpitPlayTest/testapp/conf/routes
// @DATE:Sun Jun 10 14:04:19 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Assets_1: controllers.Assets,
  // @LINE:7
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_1: controllers.Assets,
    // @LINE:7
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, Assets_1, HomeController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_1, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """inbound/sms""", """controllers.HomeController.getSms(from:String ?= null, to:String ?= null, text:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """outbound/sms""", """controllers.HomeController.outboundSms(ffrom:String ?= null, to:String ?= null, text:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sms/getToken""", """controllers.HomeController.getToken(username:String ?= null)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_getSms1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("inbound/sms")))
  )
  private[this] lazy val controllers_HomeController_getSms1_invoker = createInvoker(
    HomeController_0.getSms(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getSms",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """inbound/sms""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_outboundSms2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("outbound/sms")))
  )
  private[this] lazy val controllers_HomeController_outboundSms2_invoker = createInvoker(
    HomeController_0.outboundSms(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outboundSms",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """outbound/sms""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_getToken3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sms/getToken")))
  )
  private[this] lazy val controllers_HomeController_getToken3_invoker = createInvoker(
    HomeController_0.getToken(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getToken",
      Seq(classOf[String]),
      "GET",
      this.prefix + """sms/getToken""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Assets_versioned0_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:7
    case controllers_HomeController_getSms1_route(params@_) =>
      call(params.fromQuery[String]("from", Some(null)), params.fromQuery[String]("to", Some(null)), params.fromQuery[String]("text", Some(null))) { (from, to, text) =>
        controllers_HomeController_getSms1_invoker.call(HomeController_0.getSms(from, to, text))
      }
  
    // @LINE:8
    case controllers_HomeController_outboundSms2_route(params@_) =>
      call(params.fromQuery[String]("ffrom", Some(null)), params.fromQuery[String]("to", Some(null)), params.fromQuery[String]("text", Some(null))) { (ffrom, to, text) =>
        controllers_HomeController_outboundSms2_invoker.call(HomeController_0.outboundSms(ffrom, to, text))
      }
  
    // @LINE:9
    case controllers_HomeController_getToken3_route(params@_) =>
      call(params.fromQuery[String]("username", Some(null))) { (username) =>
        controllers_HomeController_getToken3_invoker.call(HomeController_0.getToken(username))
      }
  }
}
