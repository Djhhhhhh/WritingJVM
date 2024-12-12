package rtda.heap.methodarea;

import classfile.MemberInfo;
import classfile.attributes.impl.CodeAttribute;
import rtda.heap.constantpool.AccessFlags;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:18
 * @简介：
 */
public class Method extends ClassMember{
    public int maxStack;

    public int maxLocals;

    public byte[] code;

    public Method[] newMethods(Class clazz, MemberInfo[] memberInfos){
        Method[] methods = new Method[memberInfos.length];
        for(int i=0;i<memberInfos.length;i++){
            methods[i]=new Method();
            methods[i].clazz=clazz;
            methods[i].copyMemberInfo(memberInfos[i]);
            methods[i].copyAttributes(memberInfos[i]);
        }
        return methods;
    }
    public void copyAttributes(MemberInfo cfMethod) {
        CodeAttribute codeAttr = cfMethod.codeAttribute();
        if (null != codeAttr) {
            this.maxStack = codeAttr.maxStack();
            this.maxLocals = codeAttr.maxLocals();
            this.code = codeAttr.data();
        }
    }

    public boolean isSynchronized() {
        return 0 != (this.accessFlags & AccessFlags.ACC_SYNCHRONIZED);
    }

    public boolean isBridge() {
        return 0 != (this.accessFlags & AccessFlags.ACC_BRIDGE);
    }

    public boolean isVarargs() {
        return 0 != (this.accessFlags & AccessFlags.ACC_VARARGS);
    }

    public boolean isNative() {
        return 0 != (this.accessFlags & AccessFlags.ACC_NATIVE);
    }

    public boolean isAbstract() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ABSTRACT);
    }

    public boolean isStrict() {
        return 0 != (this.accessFlags & AccessFlags.ACC_STRICT);
    }

    public int maxStack() {
        return this.maxStack;
    }

    public int maxLocals() {
        return this.maxLocals;
    }

    public byte[] code() {
        return this.code;
    }
}
