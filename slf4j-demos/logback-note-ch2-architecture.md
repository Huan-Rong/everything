# Logback Architecture
**SEE ALSO**：[Logback Architecture](https://logback.qos.ch/manual/architecture.html)

目前，Logback 分为三个模块：
* **logback-core**：是其他两个模块的基础模块。
* **logback-classic**：天生就实现了 SLF4J API，是 log4j 非常重要的加强版本。
* **logback-access**：是与 Tomcat、Jetty 等 Servlet 容器的集成层，提供了 HTTP 访问日志的功能。

## Logger, Appender and Layout
Logback 是在 Logger、Appender、Layout 三个类的基础上构建起来的，这三种组件协调工作使开发人员根据日志类型、日志级别、日志输出位置、日志格式来记录日志。
Logger 属于 logback-classic 模块，而 Appender、Layout 属于 logback-core 模块。
作为一个通用的模块，logback-core 没有 logger 的概念。

## Logger context
与 `Sytem.out.println` 相比，日志 API 的第一个也是最重要的优点是，日志 API 可以关闭某些日志，同时允许其他日志继续输出。
这个优点假设所有日志输出语句所占用的空间，即日志空间，是可更根据开发人员的标准进行分类的。

**分类是 logger 与生俱来的特点。**
每一个 logger 都依附于 Logger Context，Logger Context 负责创建 logger 并将所有的 logger 以层次型的结构组织起来。
Root logger 位于整个 logger 层次结构的最高处。

## Hierarchical Naming Rule
Logger 的命名是大小写敏感的，并遵循层次化命名规则。
> A logger is said to be an ancestor of another logger if its name followed by a dot is a prefix of the descendant logger name.

> A logger is said to be a parent of a child logger if there are no ancestors between itself and the descendant logger.

* 如果一个 logger 的标识符加上一个 dot 是另一个 logger 标识符的前缀，那么该 logger 是另一个 logger 的祖先；
* 如果这两个 logger 之间再无其他 logger，那么该 logger 可称为另一个 logger 的父 logger；

任何一个 logger 都可以通过 `org.slf4j.LoggerFactory.getLogger` 这个静态方法获取到，参数是 logger 的名字。该方法总返回同一个 logger 对象的引用。

与生物生理矛盾的是，logback logger 可以任意顺序来创建和配置，而不一定必须先创建父 logger。

logback 环境的配置通常是在应用程序初始化时完成的，最常见的做法是通过读取一个配置文件来完成 logback 环境的配置。

使用类的全限定名来初始化 logger，这种命名策略让人一眼就能看出日志信息的来源。尽管目前看来这是一种最好最通用的方法，但 logback 并不限制使用其他的命名策略，作为开发人员，我们可以使用自己的命名策略。

## Effective Level aka Level Inheritance
logger 是可以被赋予日志级别的，日志级别有以下这些：
* TRACE
* DEBUG
* INFO 
* WARN
* ERROR

当 logger 没有设置日志级别，那么它继承祖先的日志级别，具体的规则如下：
> The effective level for a given logger L, is equal to the first non-null level in its hierarchy, starting at L itself and proceeding upwards in the hierarchy towards the root logger.

为了保证所有的 logger 最终都继承一个日志级别，root logger 总会被赋予一个日志级别，其默认的日志级别是 `DEBUG` 。

## Printing methods and the basic selection rule
**Basic Selection Rule**
> A log request of level p issued to a logger having an effective level q, is enabled if p >= q.

这条规则是 logback 的核心，它基于 TRACE < DEBUG < INFO < WARN < ERROR 的选择次序。

## Appender and Layout
基于 logger，启用或关闭某些 logging requests，这只是冰山一角。
logback 还允许 logging requests 向多个目的地输出。
从 logback 的角度来说，一个输出目的地称为一个 Appender。
目前，存在以下类型的 Appender：
* the console
* files
* remote socket servers
* MySQL、PostgreSQL、Oracle 和其他数据库
* JMS
* remote UNIX Syslog daemons

关于 Appender，存在一个称为 Appender Additivity 的规则：
> The output of a log statement of logger L will go to all the appenders in L and its ancestors. This is the meaning of the term "appender additivity".

> However, if an ancestor of logger L, say P, has the additivity flag set to false, then L's output will be directed to all the appenders in L and its ancestors up to and including P but not the appenders in any of the ancestors of P.

> Loggers have their additivity flag set to true by default.

通常情况下，用户希望不仅能够定制日志的输出目的地，而且还可以定制日志输出的格式。
定制日志的输出格式，需要将一个 layout 与 appender 关联起来，layout 负责根据用户的期望来格式化日志，而 appender 负责将格式化后的日志输出至目的地。


