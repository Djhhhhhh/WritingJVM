## 前导

​	本项目参考自《自己动手写Java虚拟机》和 小傅哥的 [用Java实现JVM虚拟机](https://bugstack.cn/md/java/develop-jvm/2019-05-02-%E7%94%A8Java%E5%AE%9E%E7%8E%B0JVM%E7%AC%AC%E4%BA%8C%E7%AB%A0%E3%80%8A%E6%90%9C%E7%B4%A2class%E6%96%87%E4%BB%B6%E3%80%8B.html)。

​	项目源码中包含自己理解写出的注释，本项目完全靠自己重新敲一边，并非完全复制粘贴；希望后续因自身水平得到提升，对于代码和JVM理解更加深刻后，可以在其中由自己独立实现的部分。

## 第一章 Java命令行工具

### 0. 前置准备

#### JCommander

​	JCommander是一个用于命令行参数解析的 Java 库，旨在简化命令行参数的解析，并提供灵活的配置选项。

@Parameter注解属性：

-   names: 定义命令行参数的名称，可以是一个字符串（如 "-version"）或字符串数组（如 {"-cp", "-classpath"}）。
-   description: 参数的描述，帮助信息中会显示。
-   order: 参数显示的顺序（影响帮助信息的顺序）。
-   help: 如果设置为 true，则该参数会被 JCommander 自动处理为帮助参数，显示帮助信息并退出。
-   required: 如果设置为 true，该参数是必需的，若未提供该参数，程序会抛出异常。
-   converter: 自定义类型转换器，用于将命令行参数转换为特定类型。
-   hidden: 如果设置为 true，则该参数在帮助信息中不会显示。

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

## 第三章 解析class文件

### 1. 目的

​	第二章实现了class文件的读取，本章对于读取的class文件做解析。

### 2. 前置知识

#### 2.1 class文件

​	是类（或者接口）信息的载体，每个class文件完整定义了一个类。

​	基本数据单位是字节，可以将class文件当成一个字节流来处理。

#### 2.1.1 class文件组成

##### 2.1.1.1 魔数

​	很多文件格式会规定满足该格式的文件以某几个固定字节开头，这几个字节作为标识作用，叫做魔数。

​	class文件的魔数为：0xCAFEBABE

##### 2.1.1.2 版本号

​	魔数之后是class文件的次版本号和主版本号。

##### 2.1.1.3 常量池

​	存储各式常量信息。

##### 2.1.1.4 类访问标记

​	指出class文件定义的是类还是接口，访问级别是public还是private，等等。

##### 2.1.1.5 类和超类索引

​	存储类名和超类名。

​	内容类似完全限定名，但是将点换成了斜线。

##### 2.1.1.6 接口索引表

​	表中存放常量池索引。

##### 2.1.1.7 字段和方法表

​	存储字段和方法信息。

### 3. 实现思路

1.  定义ClassReader帮助读取数据。
2.  定义ClassFile作为class文件组成的封装。
3.  定义常量池和实现常量解析。
4.  定义属性表和实现属性表解析

### 4.最终效果

​	配置信息：-Xjre "C:\Users\ASUS\.jdks\corretto-1.8.0_422\jre" java.lang.String

![image-20241208230210570](https://raw.githubusercontent.com/Djhhhhhh/MyPic/master/image-20241208230210570.png)
