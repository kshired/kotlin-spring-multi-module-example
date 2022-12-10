tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":clients:client-example"))
    implementation(project(":common:enum"))
    implementation(project(":common:util"))
    implementation(project(":common:error"))
    implementation(project(":domain"))
    implementation(project(":support:logging"))
    implementation(project(":storage:rdb"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}