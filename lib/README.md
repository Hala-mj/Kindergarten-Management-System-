# Dependencies

The bundled JAR files were removed from the repository. Download these versions and place them here, or add them to the project's libraries in NetBeans:

| Library | Version |
|---|---|
| MySQL Connector/J | 8.0.18 (`mysql-connector-java-8.0.18.jar`) |
| Hibernate ORM core | 4.3.1.Final (`hibernate-core`, `hibernate-entitymanager`, `hibernate-c3p0`, `hibernate-ehcache`, `hibernate-commons-annotations 4.0.4.Final`) |
| JPA 2.1 API | `hibernate-jpa-2.1-api-1.0.0.Final` |
| Supporting libs | `antlr-2.7.7`, `dom4j-1.6.1`, `javassist-3.18.1-GA`, `jboss-logging-3.1.3.GA`, `jboss-transaction-api_1.2_spec-1.0.0.Final`, `c3p0-0.9.2.1`, `mchange-commons-java-0.2.3.4`, `ehcache-core-2.4.3`, `slf4j-api-1.6.1`, `slf4j-simple-1.6.1` |
| Apache Derby | `derby.jar`, `derbyclient.jar`, which shipped with JDK 8 under `db/lib` |

In NetBeans 8.x, the **Hibernate 4.x** and **Persistence (JPA 2.1)** libraries are provided by the IDE (`libs.hibernate4-support`, `libs.jpa2-persistence`). Only the MySQL connector and the Derby JARs need to be in `lib/`.
