package classfile.constantpool.impl;

import classfile.constantpool.ConstantPool;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:34
 */
public class ConstantInterfaceMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantInterfaceMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTERFACEMETHODREF;
    }

}