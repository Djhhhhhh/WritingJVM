package classfile;

import classfile.attributes.AttributeInfo;
import classfile.constantpool.ConstantPool;

import java.util.ArrayList;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/29 16:56
 * @简介：
 *  class文件结构
 */
public class ClassFile {
    // private long magic;  魔数
    private int minorVersion; //次版本号

    private int majorVersion; //主版本号

    private ConstantPool constantPool; //常量池

    private int accessFlags; //类访问标记

    private int thisClassIdx; //类索引

    private int supperClassIdx; //超类索引

    private int[] interfaces;  //接口索引表

    private MemberInfo[] fields; //字段表

    private MemberInfo[] methods; //方法表

    private AttributeInfo[] attributes;  //属性表

    /**
     * 构造方法，按照顺序解析class文件
     * @param classData
     */
    public ClassFile(byte[] classData){
        ClassReader reader=new ClassReader(classData);
        this.readAndCheckMagic(reader);
        this.readAndCheckVersion(reader);
        this.constantPool=this.readConstantPool(reader);
        this.accessFlags=reader.readUint16();
        this.thisClassIdx=reader.readUint16();
        this.supperClassIdx=reader.readUint16();
        this.interfaces=reader.readUint16s();
        this.fields=MemberInfo.readMembers(reader,constantPool);
        this.methods=MemberInfo.readMembers(reader,constantPool);
        this.attributes=AttributeInfo.readAttributes(reader,constantPool);
    }

    /**
     * 读取检查魔数，是否位class文件的标识
     * @param reader 文件读写类
     */
    public void readAndCheckMagic(ClassReader reader){
        long magic=reader.readUint32();
        if(magic!= (0xCAFEBABEL & 0x0FFFFFFFFL)){
            throw new ClassFormatError("magic!");
        }
    }

    /**
     * 检查主次版本号
     * @param reader 文件读写类
     */
    public void readAndCheckVersion(ClassReader reader){
        this.minorVersion=reader.readUint16();
        this.majorVersion=reader.readUint16();
        switch (this.majorVersion){
            case 45:return;
            case 46: case 47: case 48: case 49:
            case 50: case 51: case 52:
                if(this.minorVersion == 0)return;
        }
        throw  new UnsupportedClassVersionError();
    }

    /**
     * 创建常量池类
     * @param reader 文件读写类
     * @return 常量池
     */
    private ConstantPool readConstantPool(ClassReader reader){
        return new ConstantPool(reader);
    }

    /**
     * 获取次版本号
     * @return
     */
    public int minorVersion(){
        return this.minorVersion;
    }

    /**
     * 获取主版本号
     * @return
     */
    public int majorVersion(){
        return this.majorVersion;
    }

    /**
     * 获取常量池
     * @return
     */
    public ConstantPool constantPool(){
        return this.constantPool;
    }

    /**
     * 获取标记
     * @return
     */
    public int accessFlags(){
        return this.accessFlags;
    }

    /**
     * 获取字段表
     * @return
     */
    public MemberInfo[] fields(){
        return this.fields;
    }

    /**
     * 获取方法表
     * @return
     */
    public MemberInfo[] methods(){
        return methods;
    }

    /**
     * 获取类名
     * @return
     */
    public String className(){
        return this.constantPool.getClassName(this.thisClassIdx);
    }

    /**
     * 获取超类名
     * @return
     */
    public String superClassName(){
        if(this.supperClassIdx<=0)return "";
        return this.constantPool.getClassName(this.supperClassIdx);
    }

    /**
     * 获取接口名
     * @return
     */
    public String[] interfaceNames(){
        String[] interfacesNames = new String[this.interfaces.length];
        for (int i = 0; i < this.interfaces.length; i++) {
            interfacesNames[i]=this.constantPool.getClassName(interfaces[i]);
        }
        return interfacesNames;
    }
}
