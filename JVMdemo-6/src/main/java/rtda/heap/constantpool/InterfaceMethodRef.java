package rtda.heap.constantpool;

import classfile.constantpool.impl.ConstantInterfaceMethodRefInfo;
import rtda.heap.methodarea.Method;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:54
 * @简介：
 */
public class InterfaceMethodRef extends MemberRef {

    private Method method;

    public static InterfaceMethodRef newInterfaceMethodRef(RunTimeConstantPool runTimeConstantPool, ConstantInterfaceMethodRefInfo refInfo) {
        InterfaceMethodRef ref = new InterfaceMethodRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method resolvedInterfaceMethod() {
        if (this.method == null){
            this.resolveInterfaceMethodRef();
        }
        return this.method;
    }

    public void resolveInterfaceMethodRef(){

    }

}