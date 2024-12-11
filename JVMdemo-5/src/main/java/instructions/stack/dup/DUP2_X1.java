package instructions.stack.dup;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;
import rtda.Slot;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:38
 * @简介：
 */
public class DUP2_X1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        Slot slot3 = stack.popSlot();
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot3);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }

}