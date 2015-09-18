publishMavenStyle := true

pomIncludeRepository := { _ => false }

publishArtifact in Test := false

bintrayRepository := "RC-releases"

bintrayPackageLabels := Seq("scala", "spray", "authentication manager", "authentication management")