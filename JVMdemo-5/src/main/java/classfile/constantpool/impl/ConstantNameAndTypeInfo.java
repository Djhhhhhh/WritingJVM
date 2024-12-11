package classfile.constantpool.impl;

import classfile.ClassReader;
import classfile.constantpool.ConstantInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:37
 */
public class ConstantNameAndTypeInfo implements ConstantInfo {

    public int nameIdx;
    public int descIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.nameIdx = reader.readUint16();
        this.descIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_NAMEANDTYPE;
    }

}