package classfile.constantpool.impl;

import classfile.ClassReader;
import classfile.constantpool.ConstantInfo;
import classfile.constantpool.ConstantPool;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:28
 */
public class ConstantClassInfo implements ConstantInfo {
    public ConstantPool constantPool;
    public int nameIdx;
    public ConstantClassInfo(ConstantPool constantPool){
        this.constantPool=constantPool;
    }
    public String name(){
        return this.constantPool.getUTF8(this.nameIdx);
    }
    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx=reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_CLASS;
    }
}
