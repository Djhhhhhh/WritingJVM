package classfile.constantpool.impl;

import classfile.ClassReader;
import classfile.constantpool.ConstantInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:32
 */
public class ConstantFloatInfo implements ConstantInfo {

    private float val;
    @Override
    public void readInfo(ClassReader reader) {
        this.val=reader.readUint64TFloat();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }
    public float value(){
        return this.val;
    }
}
