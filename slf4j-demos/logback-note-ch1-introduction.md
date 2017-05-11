# Logback Introduction
SEE ALSO: [Logback](https://logback.qos.ch/)，该文档页数超过 150 页，覆盖了 logback 的基础和高级特性，附有许多具体的例子，在描述 logback API 的同时会对其设计原理进行阐述。

## Logback 的模块划分 
目前，Logback 分为三个模块：
* **logback-core**：是其他两个模块的基础模块。
* **logback-classic**：天生就实现了 SLF4J API，是 log4j 非常重要的加强版本。
* **logback-access**：是与 Tomcat、Jetty 等 Servlet 容器的集成层，提供了 HTTP 访问日志的功能。

值得注意的是，我们可以在 logback-core 模块的基础上，构建符合自身需求的模块。

## jars needed
* slf4j-api
* logback-classic
* logback-core

**default configuration policy:**

这是 logback 的一个特性,也是有点，当用户没有编写配置文件时，logback 会添加一个 ConsoleAppender 给 root logger。 

## Built-in Status System
Logback 使用一个内置的状态系统来记录其自身内部的状态。通过使用一个称为 StatusManager 的组件，我们可以访问在 logback 的生命周期里发生的重要事件。这在诊断 logback 自身的问题时是非常有用的。

## 什么是 Appender
Appender 是一个表示日志输出目的地的类，包括 console，file，Syslog，TCP Sockets，JMS 等输出目的地。
用户可以自定义 Appender 来适应其特殊的应用场景。

## logback 的使用步骤
1. Configure the logback environment. You can do so in several more or less sophisticated ways. More on this later.
2. In every class where you wish to perform logging, retrieve a Logger instance by invoking the org.slf4j.LoggerFactory class' getLogger() method, passing the current class name or the class itself as a parameter.
3. Use this logger instance by invoking its printing methods, namely the debug(), info(), warn() and error() methods. This will produce logging output on the configured appenders.
