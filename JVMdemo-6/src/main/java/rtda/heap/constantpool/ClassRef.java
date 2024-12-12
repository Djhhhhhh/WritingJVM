package rtda.heap.constantpool;

import classfile.constantpool.impl.ConstantClassInfo;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:51
 * @简介：
 */
public class ClassRef extends SymRef {

    public static ClassRef newClassRef(RunTimeConstantPool runTimeConstantPool, ConstantClassInfo classInfo) {
        ClassRef ref = new ClassRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.className = classInfo.name();
        return ref;
    }

}