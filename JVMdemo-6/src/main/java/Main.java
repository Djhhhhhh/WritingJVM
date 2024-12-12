import classfile.ClassFile;
import classfile.MemberInfo;
import classpath.Classpath;
import rtda.Frame;
import rtda.LocalVars;
import rtda.OperandStack;
import rtda.heap.ClassLoader;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Method;

import java.util.Arrays;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 16:55
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            //注意案例测试都是基于1.8，另外jdk1.9以后使用模块化没有rt.jar
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        ClassLoader classLoader = new ClassLoader(classpath);
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        Class mainClass = classLoader.loadClass(className);
        Method mainMethod = mainClass.getMainMethod();
        if (null == mainMethod) {
            throw new RuntimeException("Main method not found in class " + cmd.getMainClass());
        }
        new Interpret(mainMethod);
    }

}