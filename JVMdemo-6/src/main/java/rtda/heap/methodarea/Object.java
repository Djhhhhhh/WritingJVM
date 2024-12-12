package rtda.heap.methodarea;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:00
 * @简介：
 */
public class Object {

    Class clazz;
    Slots fields;

    public Object(Class clazz){
        this.clazz = clazz;
        this.fields = new Slots(clazz.instanceSlotCount);
    }

    public Class clazz(){
        return this.clazz;
    }

    public Slots fields(){
        return this.fields;
    }

    public boolean isInstanceOf(Class clazz){
        return clazz.isAssignableFrom(this.clazz);
    }

}