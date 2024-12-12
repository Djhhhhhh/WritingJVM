package rtda.heap.methodarea;

import classfile.MemberInfo;
import classfile.attributes.impl.ConstantValueAttribute;
import rtda.heap.constantpool.AccessFlags;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:06
 * @简介：
 */
public class Field extends ClassMember{
    public int constValueIndex;

    public int slotId;

    public Field[] newFields(Class clazz, MemberInfo[] memberInfos){
        Field[] fields=new Field[memberInfos.length];
        for(int i=0;i<memberInfos.length;i++){
            fields[i]=new Field();
            fields[i].clazz = clazz;
            fields[i].copyMemberInfo(memberInfos[i]);
            fields[i].copyAttributes(memberInfos[i]);
        }
        return fields;
    }

    public void copyAttributes(MemberInfo memberInfo){
        ConstantValueAttribute valueAttribute=memberInfo.ConstantValueAttribute();
        if(valueAttribute!=null){
            this.constValueIndex=valueAttribute.constantValueIdx();
        }
    }

    public boolean isVolatile() {
        return 0 != (this.accessFlags & AccessFlags.ACC_VOLATILE);
    }

    public boolean isTransient() {
        return 0 != (this.accessFlags & AccessFlags.ACC_TRANSIENT);
    }

    public boolean isEnum() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ENUM);
    }

    public int constValueIndex() {
        return this.constValueIndex;
    }

    public int slotId() {
        return this.slotId;
    }

    public boolean isLongOrDouble() {
        return this.descriptor.equals("J") || this.descriptor.equals("D");
    }
}
