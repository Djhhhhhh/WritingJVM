package instructions.references;

import instructions.base.InstructionIndex16;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.constantpool.FieldRef;
import rtda.heap.constantpool.RunTimeConstantPool;
import rtda.heap.methodarea.Field;
import rtda.heap.methodarea.Object;
import rtda.heap.methodarea.Slots;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:08
 * @简介：
 */
public class GET_FIELD extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        FieldRef fieldRef = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = fieldRef.resolvedField();

        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        if (null == ref) {
            throw new NullPointerException();
        }
        String descriptor = field.descriptor();
        int slotId = field.slotId();
        Slots slots = ref.fields();

        switch (descriptor.substring(0, 1)) {
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                stack.pushInt(slots.getInt(slotId));
                break;
            case "F":
                stack.pushFloat(slots.getFloat(slotId));
                break;
            case "J":
                stack.pushLong(slots.getLong(slotId));
                break;
            case "D":
                stack.pushDouble(slots.getDouble(slotId));
                break;
            case "L":
            case "[":
                stack.pushRef(slots.getRef(slotId));
                break;
            default:
                break;
        }
    }

}
