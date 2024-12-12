package instructions.references;

import instructions.base.InstructionIndex16;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.constantpool.FieldRef;
import rtda.heap.constantpool.RunTimeConstantPool;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Field;
import rtda.heap.methodarea.Method;
import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:15
 * @简介：
 */
public class PUT_FIELD extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        Method currentMethod = frame.method();
        Class currentClazz = currentMethod.clazz();
        RunTimeConstantPool runTimeConstantPool = currentClazz.constantPool();
        FieldRef fieldRef = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = fieldRef.resolvedField();
        if (field.isStatic()) {

        }

        if (field.isFinal()) {

        }

        String descriptor = field.descriptor();
        int slotId = field.slotId();
        OperandStack stack = frame.operandStack();
        switch (descriptor.substring(0, 1)) {
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                int valInt = stack.popInt();
                Object refInt = stack.popRef();
                if (null == refInt) {
                    throw new NullPointerException();
                }
                refInt.fields().setInt(slotId, valInt);
                break;
            case "F":
                float valFloat = stack.popFloat();
                Object refFloat = stack.popRef();
                if (null == refFloat) {
                    throw new NullPointerException();
                }
                refFloat.fields().setFloat(slotId, valFloat);
                break;
            case "J":
                long valLong = stack.popLong();
                Object refLong = stack.popRef();
                if (null == refLong) {
                    throw new NullPointerException();
                }
                refLong.fields().setLong(slotId, valLong);
                break;
            case "D":
                double valDouble = stack.popDouble();
                Object refDouble = stack.popRef();
                if (null == refDouble) {
                    throw new NullPointerException();
                }
                refDouble.fields().setDouble(slotId, valDouble);
                break;
            case "L":
            case "[":
                Object val = stack.popRef();
                Object ref = stack.popRef();
                if (null == ref) {
                    throw new NullPointerException();
                }
                ref.fields().setRef(slotId, val);
                break;
            default:
                break;
        }
    }

}