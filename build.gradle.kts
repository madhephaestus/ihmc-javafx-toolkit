import org.apache.commons.lang3.SystemUtils

buildscript {
   dependencies {
      classpath("org.apache.commons:commons-lang3:3.11")
   }
}

plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.4"
   id("us.ihmc.ihmc-cd") version "1.17"
}

ihmc {
   group = "us.ihmc"
   version = "0.19.3"
   vcsUrl = "https://github.com/ihmcrobotics/ihmc-javafx-toolkit"
   openSource = true
   
   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
   api("net.sf.trove4j:trove4j:3.0.3")
   api("org.apache.commons:commons-lang3:3.11")

   api("org.fxyz3d:fxyz3d:0.1.1") {
      exclude(group = "java3d", module = "vecmath")
      exclude(group = "org.slf4j", module = "slf4j-simple")
      exclude(group = "eu.mihosoft.vrl.jcsg", module = "jcsg")
   }

   api("us.ihmc:euclid:0.16.0")
   api("us.ihmc:ihmc-yovariables:0.9.8")
   api("us.ihmc:ihmc-messager:0.1.7")
   api("us.ihmc:ihmc-graphics-description:0.19.3")
   api("us.ihmc:jassimp:4.0.0-ihmc6")

   var javaFXVersion = "11.0.2"
   api(ihmc.javaFXModule("base", javaFXVersion))
   api(ihmc.javaFXModule("controls", javaFXVersion))
   api(ihmc.javaFXModule("graphics", javaFXVersion))
   api(ihmc.javaFXModule("fxml", javaFXVersion))
   api(ihmc.javaFXModule("swing", javaFXVersion))
}

visualizersDependencies {
   api(ihmc.sourceSetProject("main"))
}
