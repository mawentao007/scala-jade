import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._

object JdBuild extends Build {
  val Organization = "jd"
  val Name = "jd"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.10.3"
  val ScalatraVersion = "2.2.2"

  lazy val project = Project (
    "jd",
    file("."),
    settings = Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ scalateSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
      ),
      scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
        Seq(
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "webTmpl",
            Seq(
              "import org.myapp.scalate.Helpers._",
              "import org.myapp.model._",
              "import net.liftweb.common._",
              "import org.joda.time._",
              "import org.scalatra.UrlGenerator"
            ),
          Seq(
            Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true),
            Binding("messageTranslatorModel", "org.myapp.model.mongo.MessageTranslator", importMembers = true, isImplicit = true, defaultValue = null),
            Binding("userSession", "org.myapp.auth.UserSession", importMembers = true, defaultValue = null),
            Binding("env", "org.myapp.util.Environment")
          ),
        Some("webTmpl")
      ),
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "mailTmpl",
            Seq(
              "import org.myapp.scalate.Helpers._",
              "import org.myapp.model._",
              "import net.liftweb.common._",
              "import org.joda.time._"
            ),
          Seq(
            Binding("i18n", "org.myapp.model.mongo.MessageTranslator", true, isImplicit = true, defaultValue = null),
            Binding("user", "User", false, defaultValue = null),
            Binding("config", "com.typesafe.config.Config", false, defaultValue = null),
            Binding("assets", "org.myapp.model.mongo.fields.AssetPaths", false, isImplicit = true, defaultValue = null),
            Binding("geonames", "org.myapp.model.Geonames", false, isImplicit = true, defaultValue = null)
          ),
        Some("mailTmpl")
      )
  )
      }
    )
  )
}
