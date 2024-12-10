package rtda;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:38
 * @简介：
 *  操作数栈 存取操作
 */
public class OperandStack {
    private int size=0; //操作数栈大小

    private Slot[] slots; //表

    public OperandStack(int maxStack){
        if(maxStack>0){
            slots=new Slot[maxStack];
            for(int i=0;i<maxStack;i++){
                slots[i]=new Slot();
            }
        }
    }

    public void pushInt(int val) {
        slots[size].num = val;
        size++;
    }

    public int popInt(){
        size--;
        return slots[size].num;
    }

    public void pushRef(Object ref){
        slots[size].ref = ref;
        size++;
    }

    public Object popRef(){
        size--;
        Object ref = slots[size].ref;
        slots[size].ref = null;
        return ref;
    }

}
