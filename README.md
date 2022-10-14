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
  servlet:
    multipart:
      max-file-size: 1000MB
      max-request-size: 1000MB
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
      
logging:
  level:
    org.springframework.boot.autoconfigure: ERROR
    com.amazonaws.util.EC2MetadataUtils: error

cloud:
  aws:
    credentials:
      access-key: {AWS IAM 액세스 키}
      secret-key: {AWS IAM 시크릿 키}
    stack:
      auto: false
    region:
      static: ap-northeast-2
    s3:
      bucket: {버킷 이름}

jwt:
  secret:
    access: {jwt 액세스 시크릿}
    refresh: {jwt 리프레쉬 시크릿}
```