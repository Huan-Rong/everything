# SLF4J
## 什么是 SLF4J
The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time. 

SLF4J 为各种日志框架（如 java.util.logging, logback, log4j）提供了一个简单的抽象层，允许用户在部署应用时选择想要的日志框架。
也就是说，用户面向 SLF4J 接口编程，而不面向具体的日志框架。
## 什么是 SLF4J Binding
An SLF4J binding designates an artifact such as slf4j-jdk14.jar or slf4j-log4j12.jar used to bind slf4j to an underlying logging framework, say, java.util.logging and respectively log4j.

SLF4J 自带有几个被称为 SLF4J Bindings 的 jar 文件，每一个 jar 文件都对应着一个日志框架。


[点击查看所有的 SLF4J Bindings](https://www.slf4j.org/manual.html#swapping)。

## 究竟需要多少个 jar 包
### 使用 Maven 构建
如果使用 Maven 来构建工程，那么只需要将一种 SLF4J Binding 的依赖即可。因为 Maven 会自动将 slf4j-api 和具体日志框架的 jar 加入到 class path 中。

### 手工构建
如果手工构建工程，那么所有的事情都需要自己来控制。这样一来，情况就变得稍微复杂点。我们需要将以下三类 jar 加入 class path 中：
* slf4j-api
* SLF4J Binding 
* 具体日志框架

当只使用 slf4j-api 进行写日志操作时会抛出以下警告信息，这是因为在 class path 中没发现 SLF4J Binding。
```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```
> This warning is printed because no slf4j binding could be found on your class path.

当使用 java.util.logging，则只需要将以下 jar 加入 class path：
* slf4j-api
* slf4j-jdk14

当使用 log4j，则需要将以下 jar 加入 class path：
* slf4j-api
* slf4j-log4j
* log4j

当使用 logback-classic，则需要将以下 jar 加入 class path：
* slf4j-api
* logback-classsic
* logback-core

## 部署时使用具体的日志框架
当需要在具体的日志框架之间切换时，只需要替换相应的 SLF4J Binding 依赖（Maven）。

需要注意的是
* 只能将一种 SLF4J Binding 的 jar 加入 class path 中。
* slf4j-api 和 SLF4J Binding 版本必须一致，如不一致，则会出错。
* 对于用户而言，所有版本的 slf4j-api 都是兼容的。

## placeholder -- what is the fastest way of logging ?
## Bridging legacy APIs