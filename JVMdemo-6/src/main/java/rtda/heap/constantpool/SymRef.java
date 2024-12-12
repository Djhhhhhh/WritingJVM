package rtda.heap.constantpool;

import rtda.heap.methodarea.Class;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:28
 * @简介：
 */
public class SymRef {
    public RunTimeConstantPool runTimeConstantPool;

    public String className;

    public Class clazz;

    public Class resolvedClass(){
        if(this.clazz != null)return this.clazz;
        Class d=this.runTimeConstantPool.getClazz();
        Class c=d.loader.loadClass(this.className);
        this.clazz = c;
        return this.clazz;
    }
}
