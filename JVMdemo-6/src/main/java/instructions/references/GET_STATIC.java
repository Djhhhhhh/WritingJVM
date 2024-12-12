package instructions.references;

import instructions.base.InstructionIndex16;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.constantpool.FieldRef;
import rtda.heap.constantpool.RunTimeConstantPool;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Field;
import rtda.heap.methodarea.Slots;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:10
 * @简介：
 */
public class GET_STATIC extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        FieldRef ref = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = ref.resolvedField();
        if (!field.isStatic()){
            throw new IncompatibleClassChangeError();
        }
        Class clazz = field.clazz();
        String descriptor = field.descriptor();
        int slotId = field.slotId();
        Slots slots = clazz.staticVars();
        OperandStack stack = frame.operandStack();
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