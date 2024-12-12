package rtda.heap.constantpool;

import classfile.constantpool.ConstantInfo;
import classfile.constantpool.ConstantPool;
import classfile.constantpool.impl.*;
import lombok.Getter;
import rtda.heap.methodarea.Class;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:50
 * @简介：
 */
public class RunTimeConstantPool {
    @Getter
    private Class clazz;
    private java.lang.Object[] constants;

    public RunTimeConstantPool(Class clazz, ConstantPool constantPool) {
        int cpCount = constantPool.getConstantInfos().length;
        this.clazz = clazz;
        this.constants = new java.lang.Object[cpCount];

        ConstantInfo[] constantInfos = constantPool.getConstantInfos();
        for (int i = 1; i < cpCount; i++) {
            ConstantInfo constantInfo = constantInfos[i];

            switch (constantInfo.tag()) {
                case ConstantInfo.CONSTANT_TAG_INTEGER:
                    ConstantIntegerInfo integerInfo = (ConstantIntegerInfo) constantInfo;
                    this.constants[i] = integerInfo.value();
                    break;
                case ConstantInfo.CONSTANT_TAG_FLOAT:
                    ConstantFloatInfo floatInfo = (ConstantFloatInfo) constantInfo;
                    this.constants[i] = floatInfo.value();
                    break;
                case ConstantInfo.CONSTANT_TAG_LONG:
                    ConstantLongInfo longInfo = (ConstantLongInfo) constantInfo;
                    this.constants[i] = longInfo.value();
                    i++;
                    break;
                case ConstantInfo.CONSTANT_TAG_DOUBLE:
                    ConstantDoubleInfo doubleInfo = (ConstantDoubleInfo) constantInfo;
                    this.constants[i] = doubleInfo.value();
                    i++;
                    break;
                case ConstantInfo.CONSTANT_TAG_STRING:
                    ConstantStringInfo stringInfo = (ConstantStringInfo) constantInfo;
                    this.constants[i] = stringInfo.string();
                    break;
                case ConstantInfo.CONSTANT_TAG_CLASS:
                    ConstantClassInfo classInfo = (ConstantClassInfo) constantInfo;
                    this.constants[i] = ClassRef.newClassRef(this, classInfo);
                    break;
                case ConstantInfo.CONSTANT_TAG_FIELDREF:
                    this.constants[i] = FieldRef.newFieldRef(this, (ConstantFieldRefInfo) constantInfo);
                    break;
                case ConstantInfo.CONSTANT_TAG_INTERFACEMETHODREF:
                    this.constants[i] = InterfaceMethodRef.newInterfaceMethodRef(this, (ConstantInterfaceMethodRefInfo) constantInfo);
                    break;
                case ConstantInfo.CONSTANT_TAG_METHODREF:
                    this.constants[i] = MethodRef.newMethodRef(this, (ConstantMethodRefInfo) constantInfo);
                    break;
                default:
            }
        }
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public java.lang.Object getConstants(int idx) {
        return constants[idx];
    }
}
