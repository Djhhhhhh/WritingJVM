package classfile.attributes.impl;

import classfile.ClassReader;
import classfile.attributes.AttributeInfo;
import classfile.constantpool.ConstantPool;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:44
 */
public class EnclosingMethodAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int classIdx;
    private int methodIdx;


    public EnclosingMethodAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUint16();
        this.methodIdx = reader.readUint16();
    }

    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> methodNameAndDescriptor() {
        if (this.methodIdx <= 0) return new HashMap<>();
        return this.constantPool.getNameAndType(this.methodIdx);
    }

}