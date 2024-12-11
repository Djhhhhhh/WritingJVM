package classfile.constantpool.impl;

import classfile.ClassReader;
import classfile.constantpool.ConstantInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:30
 */
public class ConstantDoubleInfo implements ConstantInfo {
    private double val;
    @Override
    public void readInfo(ClassReader reader) {
        this.val=reader.readUint64TDouble();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_DOUBLE;
    }
    public double value(){
        return this.val;
    }
}
