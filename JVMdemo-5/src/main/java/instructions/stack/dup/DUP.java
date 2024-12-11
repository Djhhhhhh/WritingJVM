package instructions.stack.dup;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;
import rtda.Slot;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:37
 * @简介：
 */
public class DUP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Slot slot = stack.popSlot();
        stack.pushSlot(slot);
        stack.pushSlot(slot);
    }

}