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
public class DUP2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);

    }

}