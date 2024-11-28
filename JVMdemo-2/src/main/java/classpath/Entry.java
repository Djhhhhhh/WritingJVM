package classpath;

import classpath.impl.ComositeEntry;
import classpath.impl.DirEntry;
import classpath.impl.WildcardEntry;
import classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 22:01
 */
public interface Entry{

    byte[] readClass(String className) throws IOException;

    static Entry create(String path){
        if(path.contains(File.pathSeparator)){
            return new ComositeEntry(path);
        }
        if(path.endsWith("*")){
            return new WildcardEntry(path);
        }
        if(path.endsWith(".jar")||path.endsWith(".JAR")||path.endsWith(".zip")||path.endsWith(".ZIP")){
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}

