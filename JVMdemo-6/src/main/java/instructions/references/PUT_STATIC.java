package instructions.references;

import instructions.base.InstructionIndex16;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.constantpool.FieldRef;
import rtda.heap.constantpool.RunTimeConstantPool;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Field;
import rtda.heap.methodarea.Method;
import rtda.heap.methodarea.Slots;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:16
 * @简介：
 */
public class PUT_STATIC extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        Method currentMethod = frame.method();
        Class currentClazz = currentMethod.clazz();
        RunTimeConstantPool runTimeConstantPool = currentClazz.constantPool();
        FieldRef fieldRef = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = fieldRef.resolvedField();
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
                slots.setInt(slotId, stack.popInt());
                break;
            case "F":
                slots.setFloat(slotId, stack.popFloat());
                break;
            case "J":
                slots.setLong(slotId, stack.popLong());
                break;
            case "D":
                slots.setDouble(slotId, stack.popDouble());
                break;
            case "L":
            case "[":
                slots.setRef(slotId, stack.popRef());
                break;
            default:
                break;
        }
    }

}