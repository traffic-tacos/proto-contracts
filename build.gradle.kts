plugins {
    `java-library`
    `maven-publish`
    id("com.google.protobuf") version "0.9.4"
}

group = "com.traffic-tacos"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    // gRPC and Protobuf
    api("io.grpc:grpc-stub:1.60.1")
    api("io.grpc:grpc-protobuf:1.60.1")
    api("io.grpc:grpc-kotlin-stub:1.4.0")

    // Protobuf
    api("com.google.protobuf:protobuf-java:3.25.1")
    api("com.google.protobuf:protobuf-kotlin:3.25.1")

    // Coroutines for Kotlin
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // Annotations
    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.60.1"
        }
        create("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.0:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")
                create("grpckt")
            }
            task.builtins {
                create("kotlin")
            }
        }
    }
}

// Copy generated Java files to gen/java directory
tasks.register<Copy>("copyGeneratedSources") {
    dependsOn("generateProto")
    from("$buildDir/generated/source/proto/main")
    into("gen/java")
}

tasks.build {
    dependsOn("copyGeneratedSources")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Traffic Tacos Proto Contracts")
                description.set("Centralized gRPC protocol definitions for Traffic Tacos microservices")
                url.set("https://github.com/traffic-tacos/proto-contracts")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("traffic-tacos")
                        name.set("Traffic Tacos Team")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/traffic-tacos/proto-contracts.git")
                    developerConnection.set("scm:git:ssh://github.com/traffic-tacos/proto-contracts.git")
                    url.set("https://github.com/traffic-tacos/proto-contracts")
                }
            }
        }
    }
}