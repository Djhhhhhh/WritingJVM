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
 * @Date: 2024/12/12 21:05
 * @简介：
 */
public class CHECK_CAST extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        stack.pushRef(ref);
        if (null == ref) return;
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef clazzRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = clazzRef.resolvedClass();
    }

}