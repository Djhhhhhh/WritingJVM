package classfile.attributes.impl;

import classfile.ClassReader;
import classfile.attributes.AttributeInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/8 19:43
 */
public class BootstrapMethodsAttribute implements AttributeInfo {

    BootstrapMethod[] bootstrapMethods;

    @Override
    public void readInfo(ClassReader reader) {
        int bootstrapMethodNum = reader.readUint16();
        bootstrapMethods = new BootstrapMethod[bootstrapMethodNum];
        for (int i = 0; i < bootstrapMethodNum; i++) {
            bootstrapMethods[i] = new BootstrapMethod(reader.readUint16(), reader.readUint16s());
        }
    }

    static class BootstrapMethod {
        int bootstrapMethodRef;
        int[] bootstrapArguments;

        BootstrapMethod(int bootstrapMethodRef, int[] bootstrapArguments) {
            this.bootstrapMethodRef = bootstrapMethodRef;
            this.bootstrapArguments = bootstrapArguments;
        }
    }

}