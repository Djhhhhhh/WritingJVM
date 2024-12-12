package classpath.impl;

import classpath.Entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 22:14
 */

/**
 * 目录形式类路径
 */
public class DirEntry implements Entry {
    private Path absolutePath;

    public DirEntry(String path){
        this.absolutePath= Paths.get(path).toAbsolutePath();
    }
    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(this.absolutePath.resolve(className));
    }
    @Override
    public String toString(){
        return this.absolutePath.toString();
    }
}
