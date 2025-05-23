plugins {
	// due to https://github.com/gradle/gradle/issues/15383, I cannot put version catalog referenced plugins here
	// therefore I only declare plugins that are shipping with gradle.
	id("java-gradle-plugin")
	id("maven-publish")
}

interface LazyIncludeExtension {
	val message: Property<String>
}

val extension = project.extensions.create<LazyIncludeExtension>("lazyIncludes")

publishing {
	repositories {
		maven {
			name = "localPluginRepository"
			url = uri("../out/repo")
		}
	}
}
