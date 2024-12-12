package rtda;

import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:33
 * @简介：
 *  局部变量表
 *  每位插槽可以表示一个int或者引用值
 *  连续两个插槽可以容纳一个long或者double
 */
public class LocalVars {
    private Slot[] slots;

    LocalVars(int maxLocals) {
        if (maxLocals > 0) {
            slots = new Slot[maxLocals];
            for (int i = 0; i < maxLocals; i++) {
                slots[i] = new Slot();
            }
        }
    }

    public void setInt(int idx, int val) {
        this.slots[idx].num = val;
    }

    public int getInt(int idx) {
        return slots[idx].num;
    }

    public void setFloat(int idx, float val) {
        this.slots[idx].num = (Float.valueOf(val)).intValue();
    }

    public Float getFloat(int idx) {
        int num = this.slots[idx].num;
        return (float) num;
    }

    public void setLong(int idx, long val) {
        this.slots[idx].num = (int) val;
        this.slots[idx + 1].num = (int) (val >> 32);
    }

    public Long getLong(int idx) {
        int low = this.slots[idx].num;
        int high = this.slots[idx + 1].num;
        return ((long) high << 32) | (long) low;
    }

    public void setDouble(int idx, double val) {
        setLong(idx, (long) val);
    }

    public Double getDouble(int idx) {
        return Double.valueOf(getLong(idx));
    }

    public void setRef(int idx, Object ref) {
        slots[idx].ref = ref;
    }

    public Object getRef(int idx) {
        return slots[idx].ref;
    }

    public Slot[] getSlots() {
        return slots;
    }
}
