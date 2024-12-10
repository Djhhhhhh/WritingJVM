package classfile.constantpool;

import classfile.ClassReader;
import classfile.constantpool.impl.ConstantClassInfo;
import classfile.constantpool.impl.ConstantNameAndTypeInfo;
import classfile.constantpool.impl.ConstantUtf8Info;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/29 16:57
 * @简介：
 *  常量池
 */
@Data
public class ConstantPool {
    private ConstantInfo[] constantInfos; //常量池信息
    private final int siz; //常量池大小

    /**
     * 构造方法，用于读取常量池信息
     * 需要注意的是：
     *   1.表头给出的常量大小比实际大小大1
     *   2.有效常量池的索引位1->n-1，0是无效索引。
     *   3.CONSTANT_Long_info和CONSTANT_Double_info各占两个位置
     * @param reader
     */
    public ConstantPool(ClassReader reader) {
        siz =reader.readUint16();
        constantInfos=new ConstantInfo[siz];
        for(int i=1;i<siz;i++){
            constantInfos[i]=ConstantInfo.readConstantInfo(reader,this);
            switch (constantInfos[i].tag()){
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                case ConstantInfo.CONSTANT_TAG_LONG:
                    i++;
                    break;
            }
        }
    }

    /**
     * 从常量池查找字段或方法的名字和描述符
     * @param idx
     * @return
     */
    public Map<String,String> getNameAndType(int idx){
        ConstantNameAndTypeInfo constantInfo = (ConstantNameAndTypeInfo) this.constantInfos[idx];
        Map<String ,String>map=new HashMap<>();
        map.put("name",this.getUTF8(constantInfo.nameIdx));
        map.put("_type",this.getUTF8(constantInfo.descIdx));
        return map;
    }

    /**
     * 从常量池查找类名
     * @param idx
     * @return
     */
    public String getClassName(int idx){
        ConstantClassInfo classInfo=(ConstantClassInfo) this.constantInfos[idx];
        return this.getUTF8(classInfo.nameIdx);
    }

    /**
     * 从常量池查找UTF-8字符串
     * @param idx
     * @return
     */
    public String getUTF8(int idx){
        ConstantUtf8Info utf8Info=(ConstantUtf8Info) this.constantInfos[idx];
        return utf8Info==null?"":utf8Info.str();
    }

}
