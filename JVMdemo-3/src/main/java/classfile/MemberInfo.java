package classfile;

import classfile.attributes.AttributeInfo;
import classfile.attributes.impl.CodeAttribute;
import classfile.attributes.impl.ConstantValueAttribute;
import classfile.constantpool.ConstantPool;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/29 17:16
 */
public class MemberInfo {
    private ConstantPool constantPool; //常量池
    private int accessFlags; //访问标记
    private int nameIdx; //名索引
    private int description; //描述符
    private AttributeInfo[] attributes; //属性表

    private MemberInfo(ClassReader classReader,ConstantPool constantPool){
        this.constantPool=constantPool;
        this.accessFlags= classReader.readUint16();
        this.nameIdx=classReader.readUint16();
        this.description=classReader.readUint16();
        this.attributes=AttributeInfo.readAttributes(classReader,constantPool);
    }

    /**
     * 读取字段表或者方法表
     * @param classReader
     * @param constantPool
     * @return
     */
    static MemberInfo[] readMembers(ClassReader classReader,ConstantPool constantPool){
        int fieldCount =classReader.readUint16();
        MemberInfo[] fields =new MemberInfo[fieldCount];
        for(int i = 0 ;i<fieldCount;i++){
            fields[i]=new MemberInfo(classReader,constantPool);
        }
        return fields;
    }

    public int accessFlags(){
        return this.accessFlags;
    }
    public String name(){
        return this.constantPool.getUTF8(this.nameIdx);
    }
    public String descriptor(){
        return this.constantPool.getUTF8(this.description);
    }

    public CodeAttribute codeAttribute(){
        for(AttributeInfo attributeInfo:attributes){
            //instanceof 用于检查 attrInfo 对象是否是 ConstantValueAttribute
            if(attributeInfo instanceof CodeAttribute)return (CodeAttribute) attributeInfo;
        }
        return null;
    }
    public ConstantValueAttribute ConstantValueAttribute() {
        for (AttributeInfo attrInfo : attributes) {
            if (attrInfo instanceof ConstantValueAttribute) return (ConstantValueAttribute) attrInfo;
        }
        return null;
    }
}
