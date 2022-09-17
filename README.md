# 그린거리 서버

## application.yml

```yaml
server:
  port: 8081

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://{DB 주소}/green_street?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
    username: {DB 유저네임}
    password: {DB 비밀번호}
  jackson:
    property-naming-strategy: SNAKE_CASE

  jpa:
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
    open-in-view: false
    show-sql: true
    hibernate:
      format_sql: true
      ddl-auto: update

```