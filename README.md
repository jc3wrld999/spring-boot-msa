## 🌱 Spring Boot Project


## 🚀

```
├─bin
│  ├─main
│  │  ├─com
│  │  │  └─springbootrestapi
│  │  └─templates
│  └─test
│      └─com
│          └─springbootrestapi
├─gradle
│  └─wrapper
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─springbootrestapi
    │  └─resources
    │      ├─static
    │      └─templates
    └─test
        └─java
            └─com
                └─springbootrestapi
```

/static/index.html
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    Hello World!
</body>
</html>
```
## gradle / maven

`gradle 설치`
```console
./gradlew
```
`gradle 빌드`
```console
./gradlew build
```
`gradle jar 파일로 빌드`
```console
./gradlew bootjar
```
`실행`
```console
./gradlew run
```

[`mvn 설치`](https://maven.apache.org/)

`mvn run`
```console
mvn spring-boot:run
```
#
## application.yml

```yaml
spring:
  thymeleaf:
    cache: "false"
  freemarker:
    cache: "false"
  mvc:
    static-path-pattern: /static/**
  devtools:
    livereload:
      enabled: "true"
  config:
    import: classpath:/config.yaml
logging:
  level:
    org:
      springframework:
        nodeValue: INFO
        web: DEBUG
```