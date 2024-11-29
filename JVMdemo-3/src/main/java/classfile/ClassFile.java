package classfile;

import classfile.attributes.AttributeInfo;
import classfile.constantpool.ConstantPool;

import java.util.ArrayList;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/29 16:56
 */
public class ClassFile {
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClassIdx;
    private int supperClassIdx;
    private int[] interfaces;
    private MemberInfo[] fields;
    private MemberInfo[] methods;
    private AttributeInfo[] attributes;
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
    public void readAndCheckMagic(ClassReader reader){
        long magic=reader.readUint32();
        if(magic!= (0xCAFEBABEL & 0x0FFFFFFFFL)){
            throw new ClassFormatError("magic!");
        }
    }
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
    private ConstantPool readConstantPool(ClassReader reader){
        return new ConstantPool(reader);
    }
    public int minorVersion(){
        return this.minorVersion;
    }
    public int majorVersion(){
        return this.majorVersion;
    }
    public ConstantPool constantPool(){
        return this.constantPool;
    }
    public int accessFlags(){
        return this.accessFlags;
    }
    public MemberInfo[] fields(){
        return this.fields;
    }
    public MemberInfo[] methods(){
        return methods;
    }
    public String className(){
        return this.constantPool.getClassName(this.thisClassIdx);
    }
    public String superClassName(){
        if(this.supperClassIdx<=0)return "";
        return this.constantPool.getClassName(this.supperClassIdx);
    }
    public String[] interfaceNames(){
        String[] interfacesNames = new String[this.interfaces.length];
        for (int i = 0; i < this.interfaces.length; i++) {
            interfacesNames[i]=this.constantPool.getClassName(interfaces[i]);
        }
        return interfacesNames;
    }
}
