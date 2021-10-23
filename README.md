**-Просмотр доступных обновлений библиотек**
`mvn versions:display-dependency-updates`

`[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   com.codeborne:selenide ............... 5.25.0 -> 5.25.0-selenium-4.0.0
[INFO]   com.fasterxml.jackson.dataformat:jackson-dataformat-xml ...
[INFO]                                                         2.11.1 -> 2.13.0
[INFO]   com.fasterxml.jackson.dataformat:jackson-dataformat-yaml ...
[INFO]                                                         2.12.5 -> 2.13.0
[INFO]   io.qameta.allure:allure-testng ...................... 2.14.0 -> 2.15.0
[INFO]   mysql:mysql-connector-java .......................... 8.0.26 -> 8.0.27
[INFO]   org.projectlombok:lombok .......................... 1.18.20 -> 1.18.22
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0
[INFO]
[INFO] The following dependencies in Plugin Dependencies have newer versions:
[INFO]   org.aspectj:aspectjweaver ......................... 1.9.6 -> 1.9.8.RC1
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.755 s
[INFO] Finished at: 2021-10-23T15:03:42+03:00
[INFO] ------------------------------------------------------------------------
`

**-Запуск тестов из командной строки**
`mvn -Dtest=SQLTests test`

`[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running SQLTask.SQLTests
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
2021-10-23 15:02:06.711 INFO [main] [SQLTask.SQLTests] - TABLE Customers is created
2021-10-23 15:02:06.865 INFO [main] [SQLTask.SQLTests] - first customer is created
2021-10-23 15:02:12.357 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:02:12.357 INFO [main] [SQLTask.SQLTests] - 2 25  Dmitras  Bogdanas
2021-10-23 15:02:13.063 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:02:13.063 INFO [main] [SQLTask.SQLTests] - 3 23  Dmitryan  Bogdanyan
2021-10-23 15:02:13.689 INFO [main] [SQLTask.SQLTests] - 6 21  Dima  Bogdanov
2021-10-23 15:02:13.689 INFO [main] [SQLTask.SQLTests] - User is updated
2021-10-23 15:02:20.018 INFO [main] [SQLTask.SQLTests] - TABLE Customers is removed
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.687 s - in SQLTask.SQL
Tests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  19.184 s
[INFO] Finished at: 2021-10-23T15:02:20+03:00
[INFO] ------------------------------------------------------------------------
`

**-Запуск тестов, используя mvn clean test**
`mvn clean test -Dtest=SQLTests`

`[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running SQLTask.SQLTests
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
2021-10-23 15:25:13.911 INFO [main] [SQLTask.SQLTests] - TABLE Customers is created
2021-10-23 15:25:14.135 INFO [main] [SQLTask.SQLTests] - first customer is created
2021-10-23 15:25:14.608 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:25:14.608 INFO [main] [SQLTask.SQLTests] - 2 25  Dmitras  Bogdanas
2021-10-23 15:25:20.340 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:25:20.340 INFO [main] [SQLTask.SQLTests] - 3 23  Dmitryan  Bogdanyan
2021-10-23 15:25:21.109 INFO [main] [SQLTask.SQLTests] - 5 21  Dima  Bogdanov
2021-10-23 15:25:21.109 INFO [main] [SQLTask.SQLTests] - User is updated
2021-10-23 15:25:21.719 INFO [main] [SQLTask.SQLTests] - TABLE Customers is removed
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.844 s - in SQLTask.SQL
Tests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  16.418 s
[INFO] Finished at: 2021-10-23T15:25:22+03:00
[INFO] ------------------------------------------------------------------------
`

**-Сделать SQLTests дефолтным при выполнении mvn clean test можно, добавив в pom.xml**
`<suiteXmlFile.name>src/main/resources/testRunners.task_16/task_16Executor.xml</suiteXmlFile.name>
<suiteXmlFiles><suiteXmlFile>${suiteXmlFile.name}</suiteXmlFile></suiteXmlFiles>`


**-Запустить mvn clean test -DsuiteXmlFile=your.xml**
`mvn clean test -DsuiteXmlFile=src/main/resources/testRunners.task_16/task_16Executor.xml`

`[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
2021-10-23 15:50:44.219 INFO [main] [SQLTask.SQLTests] - TABLE Customers is created
2021-10-23 15:50:44.356 INFO [main] [SQLTask.SQLTests] - first customer is created
2021-10-23 15:50:44.900 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:50:44.900 INFO [main] [SQLTask.SQLTests] - 2 25  Dmitras  Bogdanas
2021-10-23 15:50:45.878 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:50:45.878 INFO [main] [SQLTask.SQLTests] - 3 23  Dmitryan  Bogdanyan
2021-10-23 15:50:46.714 INFO [main] [SQLTask.SQLTests] - 6 21  Dima  Bogdanov
2021-10-23 15:50:46.714 INFO [main] [SQLTask.SQLTests] - User is updated
2021-10-23 15:50:47.828 INFO [main] [SQLTask.SQLTests] - TABLE Customers is removed
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 7.573 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.587 s
[INFO] Finished at: 2021-10-23T15:50:48+03:00
[INFO] ------------------------------------------------------------------------
`


**-Запуск тестов с параметрами (запуск только двух тестов createTable и addAndRemoveUser1)**
`mvn -Dtest=SQLTests#createTable+addAndRemoveUser1 test`

`[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running SQLTask.SQLTests
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
2021-10-23 15:57:29.891 INFO [main] [SQLTask.SQLTests] - TABLE Customers is created
2021-10-23 15:57:30.002 INFO [main] [SQLTask.SQLTests] - first customer is created
2021-10-23 15:57:30.602 INFO [main] [SQLTask.SQLTests] - 1 21  Dmitry  Bogdanov
2021-10-23 15:57:30.602 INFO [main] [SQLTask.SQLTests] - 2 25  Dmitras  Bogdanas
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.738 s - in SQLTask.SQLT
ests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  11.191 s
[INFO] Finished at: 2021-10-23T15:57:31+03:00
[INFO] ------------------------------------------------------------------------
`