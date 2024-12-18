package rtda;

import lombok.Getter;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:38
 * @简介：
 *  操作数栈 存取操作
 */
public class OperandStack {
    private int size = 0;
    @Getter
    private Slot[] slots;

    public OperandStack(int maxStack) {
        if (maxStack > 0) {
            slots = new Slot[maxStack];
            for (int i = 0; i < maxStack; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void pushInt(int val) {
        slots[size].num = val;
        size++;
    }

    public int popInt() {
        size--;
        return slots[size].num;
    }

    public void pushFloat(float val) {
        this.slots[this.size].num = (int) val;
        this.size++;
    }

    public float popFloat() {
        this.size--;
        return this.slots[this.size].num;
    }

    public void pushLong(long val) {
        this.slots[this.size].num = (int) val;
        this.slots[this.size + 1].num = (int) (val >> 32);
        this.size += 2;
    }

    public long popLong() {
        this.size -= 2;
        int low = this.slots[this.size].num;
        int high = this.slots[this.size + 1].num;
        return (long) (high) << 32 | (long) (low);
    }

    public void pushDouble(double val) {
        this.pushLong((long) val);
    }

    public double popDouble() {
        return this.popLong();
    }

    public void pushRef(Object ref) {
        slots[size].ref = ref;
        size++;
    }

    public Object popRef() {
        size--;
        Object ref = slots[size].ref;
        slots[size].ref = null;
        return ref;
    }

    public void pushSlot(Slot slot) {
        this.slots[this.size] = slot;
        this.size++;
    }

    public Slot popSlot(){
        this.size --;
        return this.slots[this.size];
    }

}
