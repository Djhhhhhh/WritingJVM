package rtda.heap.constantpool;


import classfile.constantpool.impl.ConstantMemberRefInfo;
import rtda.heap.methodarea.Method;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:39
 * @简介：
 */
public class MethodRef extends MemberRef {
    private Method method;

    public static MemberRef newMethodRef(RunTimeConstantPool runTimeConstantPool, ConstantMemberRefInfo refInfo){
        MemberRef ref=new MethodRef();
        ref.runTimeConstantPool=runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method ResolveMethod(){
        if(this.method==null){
            this.resolveMethodRef();
        }
        return this.method;
    }
    private void resolveMethodRef(){}
}
