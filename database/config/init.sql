CREATE TABLE SERVICE_CONFIG
(
    ID          NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    APPLICATION VARCHAR2(255),
    PROFILE     VARCHAR2(255),
    LABEL       VARCHAR2(255),
    KEYCONFIG   VARCHAR2(255),
    VALUE       VARCHAR2(255),
    ENABLE      NUMBER(1) CHECK (ENABLE IN (0, 1))
);

CREATE SEQUENCE SERVICE_CONFIG_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE USER C##orcatech IDENTIFIED BY "123456aA";
GRANT CREATE SESSION TO C##orcatech;
GRANT CREATE TABLE TO C##orcatech;
GRANT CREATE SEQUENCE TO C##orcatech;
GRANT ALL PRIVILEGES TO C##orcatech;

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('registry', 'prod', 'latest', 'server.port', '8761', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('registry', 'prod', 'latest', 'server.tomcat.accept-count', '1000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('registry', 'prod', 'latest', 'spring.security.user.name', 'ENC(yZ3mdCxWWs6w3Llv/PO1tw==)', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('registry', 'prod', 'latest', 'spring.security.user.password', 'ENC(/b0rTGiNPLFx7P6Zij2tbw==)', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('registry', 'prod', 'latest', 'eureka.client.service-url.defaultZone',
        'http://ENC(yZ3mdCxWWs6w3Llv/PO1tw==):ENC(/b0rTGiNPLFx7P6Zij2tbw==)@registry-service:8761/eureka/', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'eureka.client.service-url.defaultZone',
        'http://ENC(yZ3mdCxWWs6w3Llv/PO1tw==):ENC(/b0rTGiNPLFx7P6Zij2tbw==)@registry-service:8761/eureka/', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'server.tomcat.accept-count', '1000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'spring.datasource.url', 'jdbc:oracle:thin:@database:1521/ORCATECH', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'spring.datasource.username', 'C##ORCATECH', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'spring.datasource.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'driver-class-name', 'oracle.jdbc.driver.OracleDriver', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'jwt.token.validity', '86400000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'jwt.refreshtoken.validity', '604800000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'jwt.secret', 'Orcatech@3000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'redis.host', 'redis', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'redis.port', '6379', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'cache.duration.default', '1440', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'redis.username', 'default', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'redis.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.bootstrap-servers', 'kafka:9092', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.consumer.group-id', 'security', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.consumer.max-poll-interval', '600000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.consumer.max-poll-records', '30', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.consumer.receive-buffer', '1000000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.consumer.session-timeout', '30000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.producer.topic.login', 'socketio-server-login', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.internal.sasl.jaas-config',
        'org.apache.kafka.common.security.scram.ScramLoginModule required username="admin" password="admin" ;', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.sasl.mechanism', 'SCRAM-SHA-256', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.security-protocol', 'PLAINTEXT', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.send-timeout', '60', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'kafka.concurrency', '10', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'spring.jpa.hibernate.naming.physical-strategy',
        'org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'springdoc.api-docs.path', '/api-docs', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'springdoc.swagger-ui.path', '/index.html', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'springdoc.swagger-ui.operationsSorter', 'method', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'spring.jackson.serialization.write-dates-as-timestamps', 'false', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'url.login', 'http://172.18.0.7:8080/api/ConfirmLogin', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'elasticsearch.url', 'http://elasticsearch:9200', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'elasticsearch.username', 'elastic', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('security', 'prod', 'latest', 'elasticsearch.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'eureka.client.service-url.defaultZone',
        'http://ENC(yZ3mdCxWWs6w3Llv/PO1tw==):ENC(/b0rTGiNPLFx7P6Zij2tbw==)@registry-service:8761/eureka/', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'server.tomcat.accept-count', '1000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'server.port', '8888', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'eureka.client.service-url.defaultZone',
        'http://ENC(yZ3mdCxWWs6w3Llv/PO1tw==):ENC(/b0rTGiNPLFx7P6Zij2tbw==)@registry-service:8761/eureka/', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'redis.host', 'redis', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'redis.port', '6379', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'redis.username', 'default', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'redis.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.bootstrap-servers', 'kafka:9092', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.consumer.group-id', 'socketio', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.consumer.max-poll-interval', '600000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.consumer.max-poll-records', '30', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.consumer.receive-buffer', '1000000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.consumer.session-timeout', '30000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.consumer.topic.login', 'socketio-server-login', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.internal.sasl.jaas-config',
        'org.apache.kafka.common.security.scram.ScramLoginModule required username="admin" password="admin" ;', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.sasl.mechanism', 'SCRAM-SHA-256', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.security-protocol', 'PLAINTEXT', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.send-timeout', '60', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'kafka.concurrency', '10', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('socketio', 'prod', 'latest', 'spring.jpa.hibernate.naming.physical-strategy',
        'org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[0].filters[0]', 'StripPrefix=1', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[0].id', 'socketio', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[0].predicates[0]', 'Path=/socketio/**', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[0].uri', 'lb://socketio', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[1].filters[0]', 'StripPrefix=1', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[1].id', 'security', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[1].predicates[0]', 'Path=/security/**', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[1].uri', 'lb://security', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[2].filters[0]', 'StripPrefix=1', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[2].id', 'system', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[2].predicates[0]', 'Path=/system/**', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[2].uri', 'lb://system', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'eureka.client.service-url.defaultZone',
        'http://ENC(yZ3mdCxWWs6w3Llv/PO1tw==):ENC(/b0rTGiNPLFx7P6Zij2tbw==)@registry-service:8761/eureka/', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'server.tomcat.accept-count', '1000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'spring.datasource.url', 'jdbc:oracle:thin:@database:1521/ORCATECH', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'spring.datasource.username', 'C##ORCATECH', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'spring.datasource.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'driver-class-name', 'oracle.jdbc.driver.OracleDriver', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'jwt.token.validity', '15', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'jwt.refreshtoken.validity', '10080', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'redis.host', 'redis', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'redis.port', '6379', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'cache.duration.default', '15', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'cache.duration.user', '15', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'redis.username', 'default', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'redis.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.bootstrap-servers', 'kafka:9092', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.consumer.group-id', 'security', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.consumer.max-poll-interval', '600000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.consumer.max-poll-records', '30', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.consumer.receive-buffer', '1000000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.consumer.session-timeout', '30000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.producer.topic.login', 'socketio-server-login', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.internal.sasl.jaas-config',
        'org.apache.kafka.common.security.scram.ScramLoginModule required username="admin" password="admin" ;', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.sasl.mechanism', 'SCRAM-SHA-256', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.security-protocol', 'PLAINTEXT', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.send-timeout', '60', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'kafka.concurrency', '10', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'spring.jpa.hibernate.naming.physical-strategy',
        'org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'springdoc.api-docs.path', '/api-docs', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'springdoc.swagger-ui.path', '/index.html', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'springdoc.swagger-ui.operationsSorter', 'method', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'elasticsearch.url', 'http://elasticsearch:9200', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'elasticsearch.username', 'elastic', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('system', 'prod', 'latest', 'elasticsearch.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[3].filters[0]', 'StripPrefix=1', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[3].id', 'categories', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[3].predicates[0]', 'Path=/categories/**', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('gateway', 'prod', 'latest', 'spring.cloud.gateway.routes[3].uri', 'lb://categories', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'eureka.client.service-url.defaultZone',
        'http://ENC(yZ3mdCxWWs6w3Llv/PO1tw==):ENC(/b0rTGiNPLFx7P6Zij2tbw==)@registry-service:8761/eureka/', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'server.tomcat.accept-count', '1000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'spring.datasource.url', 'jdbc:oracle:thin:@database:1521/ORCATECH', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'spring.datasource.username', 'C##ORCATECH', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'spring.datasource.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'driver-class-name', 'oracle.jdbc.driver.OracleDriver', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'redis.host', 'redis', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'redis.port', '6379', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'cache.duration.default', '15', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'cache.duration.user', '15', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'redis.username', 'default', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'redis.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.bootstrap-servers', 'kafka:9092', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.consumer.group-id', 'categories', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.consumer.max-poll-interval', '600000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.consumer.max-poll-records', '30', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.consumer.receive-buffer', '1000000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.consumer.session-timeout', '30000', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.internal.sasl.jaas-config',
        'org.apache.kafka.common.security.scram.ScramLoginModule required username="admin" password="admin" ;', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.sasl.mechanism', 'SCRAM-SHA-256', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.security-protocol', 'PLAINTEXT', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.send-timeout', '60', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'kafka.concurrency', '10', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'elasticsearch.url', 'http://elasticsearch:9200', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'elasticsearch.username', 'elastic', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'elasticsearch.password', '123456aA', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'spring.jpa.hibernate.naming.physical-strategy',
        'org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'springdoc.api-docs.path', '/api-docs', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'springdoc.swagger-ui.path', '/index.html', 1);

INSERT INTO SERVICE_CONFIG (APPLICATION, PROFILE, LABEL, KEYCONFIG, VALUE, ENABLE)
VALUES ('categories', 'prod', 'latest', 'springdoc.swagger-ui.operationsSorter', 'method', 1);

CREATE TABLE APPLICATION_SETTING
(
    ID                   NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    SETTING_KEY          VARCHAR2(255),
    SETTING_VALUE        VARCHAR2(255),
    SETTING_DISPLAY_NAME VARCHAR2(255),
    IS_READ_ONLY         NUMBER(1) CHECK (IS_READ_ONLY IN (0, 1)),
    COMPANY_ID           VARCHAR2(255),
    DESCRIPTION          VARCHAR2(500),
    ACTIVATED            NUMBER(1) CHECK (ACTIVATED IN (0, 1)),
    RELE_ID              NUMBER,
    TYPE_ID              NUMBER
);

CREATE SEQUENCE APPLICATION_SETTING_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE COMPANY
(
    ID                        NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    COMPANY_ID                VARCHAR2(255),
    COMPANY_NAME              VARCHAR2(255),
    REGION_ID                 NUMBER,
    CITY_ID                   NUMBER,
    WARD_ID                   NUMBER,
    ADDRESSES                 VARCHAR2(255),
    PHONE_NUMBER              VARCHAR2(13),
    COMPANY_EMAIL             VARCHAR2(255),
    COMPANY_WEBSITE           VARCHAR2(255),
    TAX_IDENTIFICATION_NUMBER VARCHAR2(255),
    IMAGE_ORDER_THUMBURL      VARCHAR2(255),
    IMAGE_ORDER_PREVIEWURL    VARCHAR2(255),
    CREATED                   DATE,
    CREATED_BY_USER_ID        NUMBER,
    MODIFIED                  DATE,
    MODIFIED_BY_USER_ID       NUMBER,
    RECORD_STATUS_ID          NUMBER
);

CREATE SEQUENCE COMPANY_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE COMPANY_EMPLOYEES
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ROLE                VARCHAR2(255),
    COMPANY_ID          VARCHAR2(255),
    USER_USER_ID        NUMBER,
    ARCHIVED_ID         NUMBER,
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE COMPANY_EMPLOYEES_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE ENTITY
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    CODE                VARCHAR2(255),
    NAME                VARCHAR2(255),
    TYPE                NUMBER,
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE ENTITY_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE PRIVILEGE
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    CODE                VARCHAR2(255),
    PARENT_CODE         VARCHAR2(255),
    NAME                VARCHAR2(255),
    ENABLE              NUMBER(1) CHECK (ENABLE IN (0, 1)),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE PRIVILEGE_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE PRIVILEGE_ENTITY
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PRIVILEGE_ID        NUMBER,
    ENTITY_ID           NUMBER,
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE PRIVILEGE_ENTITY_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE ROLE
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ROLE_NAME           VARCHAR2(255),
    IS_DELETED          NUMBER(1) CHECK (IS_DELETED IN (0, 1)),
    COMPANY_ID          VARCHAR2(255),
    DESCRIPTION         VARCHAR2(255),
    ROLE_TYPE_ID        NUMBER,
    IS_DEFAULT          NUMBER(1) CHECK (IS_DEFAULT IN (0, 1)),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE ROLE_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE ROLE_PRIVILEGE
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ROLE_ID             NUMBER,
    PRIVILEGE_ID        NUMBER,
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE ROLE_PRIVILEGE_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE ROLE_TYPE
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ROLE_NAME           VARCHAR2(255),
    DESCRIPITION        VARCHAR2(255),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE ROLE_TYPE_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE SETTINGS
(
    ID         NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    KEY        VARCHAR2(255),
    VALUE      VARCHAR2(255),
    IS_ACTIVE  NUMBER(1) CHECK (IS_ACTIVE IN (0, 1)),
    COMPANY_ID VARCHAR2(255)
);

CREATE SEQUENCE SETTINGS_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE USER_PROFILE
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    USERNAME            VARCHAR2(255),
    PASSWROD            VARCHAR2(255),
    FULL_NAME           VARCHAR2(255),
    BIRTH_DATE          Date,
    GENDER              NUMBER,
    EMAIL               VARCHAR2(255),
    PHONE_NUMBER        VARCHAR2(13),
    COMPANY_ID          VARCHAR2(255),
    IS_ACTIVE           NUMBER(1) CHECK (IS_ACTIVE IN (0, 1)),
    CITIZED_ID_NUMBER   VARCHAR2(255),
    ENABLE_NT           NUMBER(1) CHECK (ENABLE_NT IN (0, 1)),
    REGION_ID           NUMBER,
    PROVINCE_ID         NUMBER,
    CITY_ID             NUMBER,
    WARD_ID             NUMBER,
    ADDRESSEA           VARCHAR2(255),
    ZIP_CODE            VARCHAR2(255),
    ENTITY_ID           NUMBER,
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE USER_PROFILE_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE USER_ROLE
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    USER_ID             NUMBER,
    ROLE_ID             NUMBER,
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE USER_ROLE_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE PROCESS
(
    ID          NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    BATCHKEY    VARCHAR2(255),
    COMPANY_ID  VARCHAR2(255),
    STAR_DATE   Date,
    END_DATE    Date,
    TOTAL       NUMBER,
    STATUS      NUMBER,
    RETURN_CODE NUMBER,
    MESSAGE     VARCHAR2(255),
    CREATE_BY   NUMBER
);

CREATE SEQUENCE PROCESS_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE PROCESS_DTL
(
    ID          NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PROCESS_ID  NUMBER,
    INDEX_DATA  NUMBER,
    DATA_ROW    VARCHAR2(255),
    STAR_DATE   Date,
    END_DATE    Date,
    STATUS      NUMBER,
    RETURN_CODE NUMBER,
    MESSAGE     VARCHAR2(255)
);

CREATE SEQUENCE PROCESS_DTL_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE REGIONS
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NAME                VARCHAR2(255),
    CODE                VARCHAR2(255),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE REGIONS_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE PROVINCES
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    REGION_ID           NUMBER,
    NAME                VARCHAR2(255),
    CODE                VARCHAR2(255),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE PROVINCES_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE CITIES
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PROVINCE_ID           NUMBER,
    NAME                VARCHAR2(255),
    CODE                VARCHAR2(255),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE CITIES_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;

CREATE TABLE WARDS
(
    ID                  NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    CITIES_ID           NUMBER,
    NAME                VARCHAR2(255),
    CODE                VARCHAR2(255),
    CREATED             DATE,
    CREATED_BY_USER_ID  NUMBER,
    MODIFIED            DATE,
    MODIFIED_BY_USER_ID NUMBER,
    RECORD_STATUS_ID    NUMBER
);

CREATE SEQUENCE WARDS_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999999999999999999999999999999999
    CACHE 20
    NOCYCLE
    NOORDER;