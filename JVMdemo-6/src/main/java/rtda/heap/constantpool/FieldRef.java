package rtda.heap.constantpool;

import classfile.constantpool.impl.ConstantFieldRefInfo;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Field;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:52
 * @简介：
 */
public class FieldRef extends MemberRef {

    private Field field;

    public static FieldRef newFieldRef(RunTimeConstantPool runTimeConstantPool, ConstantFieldRefInfo refInfo) {
        FieldRef ref = new FieldRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Field resolvedField() {
        if (null == field) {
            try {
                this.resolveFieldRef();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return this.field;
    }

    private void resolveFieldRef() throws NoSuchFieldException {
        Class d = this.runTimeConstantPool.getClazz();
        Class c = this.resolvedClass();

        Field field = this.lookupField(c, this.name, this.descriptor);
        if (null == field){
            throw new NoSuchFieldException();
        }

        if (!field.isAccessibleTo(d)){
            throw new IllegalAccessError();
        }

        this.field = field;
    }

    private Field lookupField(Class c, String name, String descriptor) {
        for (Field field : c.fields) {
            if (field.name.equals(name) && field.descriptor.equals(descriptor)) {
                return field;
            }
        }

        for (Class iface : c.interfaces) {
            Field field = lookupField(iface, name, descriptor);
            if (null != field) return field;
        }

        if (c.superClass != null) {
            return lookupField(c.superClass, name, descriptor);
        }

        return null;
    }

}