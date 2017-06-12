# GitHub 入门与实践
## 第一章
### Git
将 Git 已跟踪管理的文件从 Git 中删除，但在本地中不删除；即不再跟踪管理该文件；
git rm --cached --force slf4j-demos/slf4j-demos.iml

### 敏捷软件开发
* 敏捷软件开发是一种软件工程方法论
* 如何将敏捷软件开发导入开发现场
* 一天之内多次部署的开发体制

### 内容提要
* Git 的基础知识和操作方法
* GitHub 的各种功能以及代表功能 Pull Request
* GitHub 与其他工具或服务的集成
* GitHub 的开发流程以及如何将 GitHub 引入到企业

### 学习目标
* 在开发现场使用 GitHub 进行高效开发
* 社会化编程入门
* 初步掌握书中所提及的软件工程方法论

### BlingBling Words
* 开源
* 社会化编程

### 社会化编程的好处
* 与全世界开源开发者交流代码与心得
* 为感兴趣的开源软件作贡献
* 与大神交流
* 社会化编程可以让开发者之间的交流协作更加紧密、高效，让开发者时刻观察到世界技术前沿的变化。

### 学习方法
* 在实践与探索中学习

### 问题
* 企业导入社会化编程的利弊
* 企业应当如何借鉴 GitHub 的管理模式

### 什么是 GitHub
* GitHub 是一个社会化编程平台，它为开发者提供的 Git 仓库的托管服务。
* GitHub 并不只是 Git 仓库的托管服务，Git 仓库的托管服务是 GitHub 项目的目标之一，这只是漫长路程上的一个点而已。
* GitHub 为开发者或团队提供了一系列功能，帮助其高效率、高品质地进行代码编写。
* GitHub 和 Git 是完全不同的两个东西。
* GitHub 最大的特征是面向人。

### 协同形式变化
在软件开发者之间，一直都没有一个用来辅助多人协同编程的关键性软件，如同 CRM 和 Groupware。因此，软件开发者们往往要将版本管理系统、BUG 跟踪系统、代码审查工具、邮件列表、IRC 等总舵工具组合在一起，以便实现多人合作。
然而，GitHub 的出现为其带来了巨大的变化。

### Pull Request
Pull Request 是指开发者在本地对源代码进行更改后，向 GitHub 中托管的 Git 仓库请求合并的功能。
GitHub 的 Pull Request 不但能轻松查看源代码的前后差别，还可以对指定的一行代码进行评论。

任务管理和 BUG 报告可以通过 Issue 进行交互。
Wiki 功能可以让开发者轻松创建文档，并进行公开、共享。Wiki 更新的历史记录也在 Git 中管理，可以让用户轻松更改。

## 第二章： Git 的导入
Git 是分布式版本管理系统。   
### Fork
* Fork 就是将 GitHub 的某个特定仓库复制到自己的账户下。
* Fork 出来的仓库与原仓库是两个不同的仓库。
* 实际上，所有仓库之间都可以进行 pull 和 push。
* 只要脑中掌握了多个仓库并存的概念，学习分布式版本管理系统并不是什么难事。

疑问：Fork 是 GitHub 提供的功能？

### 换行
* GitHub 中公开的代码大部分都是以 Mac 或 Linux 中的 LF（Line Feed） 换行的。
* Windows 中是以 CRLF（Carriage Return + Line Feed） 换行的，所以在费对应的编辑器中将不能正常显示。
* Git 可以通过设置自动转换这些换行符。

### 初始化设置
* 设置使用 Git 时的姓名和邮箱，这两个信息会用到 Git 的提交日志中：`git config --global user.name 'Huan-Rong'` `git config user.email 'zhenghuanrong@yeah.net'`
* 提高命令输出的可读性：`git config --global color.ui auto`

## 第三章：使用 GitHub 的前期准备
* 创建 GitHub 账号，设置 SSH Key
* 使用 Follow 关注其他用户
* 使用 Watch 获取其他仓库的最新开发信息
* 在 GitHub 上进行交流时用到的 Issue、评论、Wiki，都可以用 GFM 语法表述，GFM 语法是在 Markdown 语法基础上扩充而来。
* 暂存区：在 Index 数据结构中记录文件提交之前的状态。