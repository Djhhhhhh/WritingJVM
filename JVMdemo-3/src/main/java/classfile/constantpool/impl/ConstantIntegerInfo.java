package classfile.constantpool.impl;

import classfile.ClassReader;
import classfile.constantpool.ConstantInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:34
 */
public class ConstantIntegerInfo implements ConstantInfo {

    private int val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint32TInteger();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }

    public int value(){
        return this.val;
    }

}