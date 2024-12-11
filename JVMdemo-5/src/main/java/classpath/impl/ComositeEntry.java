package classpath.impl;

import classpath.Entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/28 22:07
 */

/**
 * 由更细化的Entry组成的组合Entry
 */
public class ComositeEntry implements Entry {

    private final List<Entry> entryList = new ArrayList<>();

    public ComositeEntry(String pathList){
        String[] paths=pathList.split(File.pathSeparator);
        for(String path:paths) {
            entryList.add(Entry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        for (Entry entry : entryList) {
            try {
                return entry.readClass(className);
            } catch (Exception ignored) {
            }
        }
        throw new IOException("class not found " + className);
    }

    @Override
    public String toString(){
        String[] strs = new String[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            strs[i] = entryList.get(i).toString();
        }
        return String.join(File.pathSeparator, strs);
    }
}
