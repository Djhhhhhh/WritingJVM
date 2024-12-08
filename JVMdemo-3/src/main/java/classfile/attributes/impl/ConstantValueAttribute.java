package classfile.attributes.impl;

import classfile.ClassReader;
import classfile.attributes.AttributeInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:43
 */
public class ConstantValueAttribute implements AttributeInfo {

    private int constantValueIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.constantValueIdx = reader.readUint16();
    }

    public int constantValueIdx(){
        return this.constantValueIdx;
    }

}