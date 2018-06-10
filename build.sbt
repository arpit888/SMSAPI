name := """TestApp"""
organization := "Plivo"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq( 
guice,
ehcache,
"org.mockito" % "mockito-core" % "2.10.0" % "test"
)

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes
EclipseKeys.preTasks := Seq(compile in Compile)                  // Compile the project before generating Eclipse files, so that .class files for views and routes are present
EclipseKeys.skipParents in ThisBuild := false

