package instructions.stack.swap;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;
import rtda.Slot;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:40
 * @简介：
 */
public class SWAP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        stack.pushSlot(slot1);
        stack.pushSlot(slot2);
    }
}