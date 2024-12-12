package classfile.attributes.impl;

import classfile.ClassReader;
import classfile.attributes.AttributeInfo;
import classfile.constantpool.ConstantPool;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:46
 */
public class SignatureAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int signatureIdx;

    public SignatureAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.signatureIdx = reader.readUint16();
    }

    public String signature(){
        return this.constantPool.getUTF8(this.signatureIdx);
    }

}