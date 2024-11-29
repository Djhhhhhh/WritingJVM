package classpath.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 22:30
 */

/**
 * 本质上也是CompositeEntry
 * 处理包含通配符 * 的路径，并将其转换为实际的 JAR 文件路径列表
 */
public class WildcardEntry extends ComositeEntry{

    public WildcardEntry(String pathList) {
        super(toPathList(pathList));
    }

    private static String toPathList(String wildcardPath) {
        String baseDir = wildcardPath.replace("*", "");
        try {
            return Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            return "";
        }
    }
}
