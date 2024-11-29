package classpath.impl;

import classpath.Entry;

import java.io.IOException;
import java.nio.file.*;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 22:24
 */

/**
 * ZIP获JAR文件形式类路径
 */
public class ZipEntry implements Entry {
    private Path absolutePath;

    public ZipEntry(String path){
        this.absolutePath= Paths.get(path).toAbsolutePath();
    }
    @Override
    public byte[] readClass(String className) throws IOException {
        try(FileSystem zipFs= FileSystems.newFileSystem(this.absolutePath,null)){
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }
    @Override
    public String toString(){
        return this.absolutePath.toString();
    }
}
