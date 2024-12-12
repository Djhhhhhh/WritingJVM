package instructions.references;

import instructions.base.InstructionIndex16;
import rtda.Frame;
import rtda.OperandStack;
import rtda.heap.constantpool.ClassRef;
import rtda.heap.constantpool.RunTimeConstantPool;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:11
 * @简介：
 */
public class INSTANCE_OF extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        if (null == ref){
            stack.pushInt(0);
            return;
        }
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef classRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = classRef.resolvedClass();
        if (ref.isInstanceOf(clazz)){
            stack.pushInt(1);
        } else {
            stack.pushInt(0);
        }
    }

}