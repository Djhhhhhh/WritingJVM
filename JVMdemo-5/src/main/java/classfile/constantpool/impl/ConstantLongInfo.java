package classfile.constantpool.impl;

import classfile.ClassReader;
import classfile.constantpool.ConstantInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:35
 */
public class ConstantLongInfo implements ConstantInfo {

    private long val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TLong();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_LONG;
    }

    public long value(){
        return this.val;
    }

}