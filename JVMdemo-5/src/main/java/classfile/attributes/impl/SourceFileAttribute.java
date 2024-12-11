package classfile.attributes.impl;

import classfile.ClassReader;
import classfile.attributes.AttributeInfo;
import classfile.constantpool.ConstantPool;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:46
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int sourceFileIdx;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIdx = reader.readUint16();
    }

    public String fileName(){
        return this.constantPool.getUTF8(this.sourceFileIdx);
    }

}