import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.List;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 16:55
 */
public class Cmd {
    //该属性通过@Parameter注解定义命令行参数为-?/-help的时候，将helpFlag标记为true。
    @Parameter(names = {"-?", "-help"}, description = "print help message", order = 3, help = true)
    boolean helpFlag = false;

    //该属性通过@Parameter注解定义命令行参数为-version的时候，将versionFlag标记为true。
    @Parameter(names = "-version", description = "print version and exit", order = 2)
    boolean versionFlag = false;

    //该属性通过@Parameter注解定义命令行参数为-cp/-classpath的时候，用classpath记录路径。
    @Parameter(names = {"-cp", "-classpath"}, description = "classPath", order = 1)
    String classpath;

    @Parameter(names="-Xjre",description = "path to jre",order = 4)
    String jre;

    //该属性存储命令行传入的所有参数。
    @Parameter(description = "show main class and args")
    List<String> mainClassAndArgsList;

    //标记命令是否正确运行
    boolean ok;

    /**
     * 用于获取类名
     * @return 类名
     */
    String getMainClass() {
        return mainClassAndArgsList != null && !mainClassAndArgsList.isEmpty()
                ? mainClassAndArgsList.get(0)
                : null;
    }

    /**
     * 用于获取运行的的输入用例
     * @return 输入用例
     */
    List<String> getAppArgs() {
        return mainClassAndArgsList != null && mainClassAndArgsList.size() > 1
                ? mainClassAndArgsList.subList(1, mainClassAndArgsList.size())
                : null;
    }

    /**
     * 执行Cmd
     * @param argv 命令行参数
     * @return cmd
     */
    static Cmd parse(String[] argv) {
        Cmd args = new Cmd();
        JCommander cmd = JCommander.newBuilder().addObject(args).build();
        cmd.parse(argv);
        args.ok = true;
        return args;
    }

}
