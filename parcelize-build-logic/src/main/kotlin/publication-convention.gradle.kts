/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import java.util.Base64

plugins {
    id("javadoc-stub-convention")
    id("org.gradle.maven-publish")
    id("signing")
}

publishing {
    repositories.maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
        name = "OSSRH"

        credentials {
            username = System.getenv("OSSRH_USER")
            password = System.getenv("OSSRH_KEY")
        }
    }

    // Make sure to avoid duplicate publications
    val publicationsFromMainHost = listOf(
        "wasm32",
        "jvm",
        "js",
        "kotlinMultiplatform",
        "androidRelease",
        "androidDebug",
        "linuxArm64",
        "linuxArm32Hfp",
        "linuxX64"
    )

    publications
        .matching { it.name in publicationsFromMainHost }
        .all {
            val targetPublication = this@all
            tasks.withType<AbstractPublishToMaven>()
                .matching { it.publication == targetPublication }
                .all { onlyIf { System.getProperty("IS_MAIN_HOST") == "true" } }
        }

    publications.withType<MavenPublication> {

        // Provide artifacts information requited by Maven Central
        pom {
            name.set("MOKO parcelize")
            description.set("@Parcelize support for android from common code in Kotlin Multiplatform")
            url.set("https://github.com/icerockdev/moko-parcelize")
            licenses {
                license {
                    name.set("Apache-2.0")
                    distribution.set("repo")
                    url.set("https://github.com/icerockdev/moko-parcelize/blob/master/LICENSE.md")
                }
            }

            developers {
                developer {
                    id.set("Alex009")
                    name.set("Aleksey Mikhailov")
                    email.set("aleksey.mikhailov@icerockdev.com")
                }
                developer {
                    id.set("nrobi144")
                    name.set("Nagy Robert")
                    email.set("nagyrobi144@gmail.com")
                }
            }

            scm {
                connection.set("scm:git:ssh://github.com/icerockdev/moko-parcelize.git")
                developerConnection.set("scm:git:ssh://github.com/icerockdev/moko-parcelize.git")
                url.set("https://github.com/icerockdev/moko-parcelize")
            }
        }
    }

    signing {
        val signingKeyId: String? = System.getenv("SIGNING_KEY_ID")
        val signingPassword: String? = System.getenv("SIGNING_PASSWORD")
        val signingKey: String? = System.getenv("SIGNING_KEY")?.let { base64Key ->
            String(Base64.getDecoder().decode(base64Key))
        }
        if (signingKeyId != null) {
            useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
            sign(publishing.publications)
        }
    }
}
