package classpath;

import classpath.impl.WildcardEntry;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 22:33
 */
public class Classpath {
    private Entry bootstrapClasspath;
    private Entry extensionClasspath;
    private Entry userClasspath;

    /**
     * 构造方法执行分为获取jre中的启动类路径和扩展类路径 获取用户类路径
     * @param jreOption jre目录路径参数
     * @param cpOption 用户路径参数
     */
    public Classpath(String jreOption,String cpOption){
        bootstrapAndExtensionClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    /**
     * 获取jre中的启动类路径和扩展类路径
     * @param jreOption jre目录路径参数
     */
    private void bootstrapAndExtensionClasspath(String jreOption){
        String jreDir=getJreDir(jreOption);
        String jreLibPath= Paths.get(jreDir,"lib")+ File.separator+"*";
        bootstrapClasspath=new WildcardEntry(jreLibPath);
        String jreExtPath=Paths.get(jreDir,"lib","ext")+File.separator+"*";
        extensionClasspath=new WildcardEntry(jreExtPath);
    }

    /**
     * 检查jreOption参数 返回jre目录路径
     * @param jreOption jre目录路径参数
     * @return
     */
    private static String getJreDir(String jreOption){
        if (jreOption!=null&& Files.exists(Paths.get(jreOption))){
            return jreOption;
        }
        if(Files.exists(Paths.get("./jre"))){
            return "./jre";
        }
        String jh=System.getenv("JAVA_HOME");
        if(jh!=null){
            return Paths.get(jh,"jre").toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }

    /**
     * 获取用户类路径
     * @param cpOption 用户路径参数
     */
    private void parseUserClasspath(String cpOption){
        if(cpOption==null){
            cpOption=".";
        }
        userClasspath=Entry.create(cpOption);
    }

    /**
     * 读取对应的字节码文件返回
     * @param className 字节码文件名称
     * @return 字节码
     * @throws Exception 异常
     */
    public byte[] readClass(String className) throws Exception{
        className=className+".class";
        try{
            return  bootstrapClasspath.readClass(className);
        }catch (Exception ignored){

        }
        try {
            return extensionClasspath.readClass(className);
        }catch (Exception ignored){

        }
        return userClasspath.readClass(className);
    }
}
