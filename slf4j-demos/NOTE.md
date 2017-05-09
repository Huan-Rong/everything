# SLF4J
## 什么是 SLF4J
> The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time. 

SLF4J 为各种日志框架（如 java.util.logging, logback, log4j）提供了一个简单的抽象层，允许用户在部署应用时选择想要的日志框架。
也就是说，用户面向 SLF4J 接口编程，而不面向具体的日志框架。
## SLF4J Binding

> An SLF4J binding designates an artifact such as slf4j-jdk14.jar or slf4j-log4j12.jar used to bind slf4j to an underlying logging framework, say, java.util.logging and respectively log4j.

当使用 Maven 时，依赖 SLF4J binding 即可。
当没使用 Maven 时，需要手动将 slf4j-api，SLF4J binding，以及日志框架的 jar 包加入到 class path 中。

当仅仅使用 slf4j-api 这个 jar 包进行写日志操作时会抛出警告信息，这是因为在 class path 中没发现 slf4j binding。原文如下：

> This warning is printed because no slf4j binding could be found on your class path.
### placeholder -- what is the fastest way of logging ?
### Bridging modules