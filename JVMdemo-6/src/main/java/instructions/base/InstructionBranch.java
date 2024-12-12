package instructions.base;

import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:22
 * @简介：
 */
public class InstructionBranch implements Instruction {

    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }

    protected boolean _acmp(Frame frame){
        OperandStack stack = frame.operandStack();
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        return ref1.equals(ref2);
    }

}