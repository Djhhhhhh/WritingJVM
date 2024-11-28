## 前导

​	本项目参考自《自己动手写Java虚拟机》和 小傅哥的 [用Java实现JVM虚拟机](https://bugstack.cn/md/java/develop-jvm/2019-05-02-%E7%94%A8Java%E5%AE%9E%E7%8E%B0JVM%E7%AC%AC%E4%BA%8C%E7%AB%A0%E3%80%8A%E6%90%9C%E7%B4%A2class%E6%96%87%E4%BB%B6%E3%80%8B.html)。

​	项目源码中包含自己理解写出的注释，本项目完全靠自己重新敲一边，并非完全复制粘贴；希望后续因自身水平得到提升，对于代码和JVM理解更加深刻后，可以在其中由自己独立实现的部分。

## 前置准备

### 1. JCommander

​	JCommander是一个用于命令行参数解析的 Java 库，旨在简化命令行参数的解析，并提供灵活的配置选项。

#### 1.1 @Parameter注解属性

-   names: 定义命令行参数的名称，可以是一个字符串（如 "-version"）或字符串数组（如 {"-cp", "-classpath"}）。
-   description: 参数的描述，帮助信息中会显示。
-   order: 参数显示的顺序（影响帮助信息的顺序）。
-   help: 如果设置为 true，则该参数会被 JCommander 自动处理为帮助参数，显示帮助信息并退出。
-   required: 如果设置为 true，该参数是必需的，若未提供该参数，程序会抛出异常。
-   converter: 自定义类型转换器，用于将命令行参数转换为特定类型。
-   hidden: 如果设置为 true，则该参数在帮助信息中不会显示。

## 第一章 Java命令行工具

### 1. 目的

​	通过编写命令行工，支持运行Java中的基础命令。

​	在命令行工具中，可以使用基础命令启动Java虚拟机来执行指定的类。

### 2. 实现思路

​	通过使用JCommander创建自定义命令行参数，实现基础的Java命令。

### 3. 最终效果

#### 3.1 参数 -cp foo MyApp arg1 arg2

![image-20241128234123816](https://raw.githubusercontent.com/Djhhhhhh/MyPic/master/image-20241128234123816.png)

#### 3.2 参数 -help

![image-20241128234210754](https://raw.githubusercontent.com/Djhhhhhh/MyPic/master/image-20241128234210754.png)

#### 3.3 参数 -version

![image-20241128234329123](https://raw.githubusercontent.com/Djhhhhhh/MyPic/master/image-20241128234329123.png)

## 第二章 搜索class文件

### 1. 目的

​	获取依赖的所有类。

#### 1.1 类路径

-   启动类路径（bootstrap classpath）
-   扩展类路径（extension classpath
-   用户类路径（user classpath）

### 2. 实现思路

​	Entry通过简单工厂模式，生成对应的实体，然后通过对应的方法读到class文件，并把字节码取出返回。

​	CompositeEntry将不同种的Entry复合在一起（组合模式）

#### 2.1 UML类图

![image-20241129001227887](https://raw.githubusercontent.com/Djhhhhhh/MyPic/master/image-20241129001227887.png)

### 3. 最终效果

![image-20241129005130370](https://raw.githubusercontent.com/Djhhhhhh/MyPic/master/image-20241129005130370.png)
