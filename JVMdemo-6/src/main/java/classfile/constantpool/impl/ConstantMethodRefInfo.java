package classfile.constantpool.impl;

import classfile.constantpool.ConstantPool;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:36
 */
public class ConstantMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODREF;
    }
}