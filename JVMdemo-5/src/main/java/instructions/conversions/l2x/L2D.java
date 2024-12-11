package instructions.conversions.l2x;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:32
 * @简介：
 */
public class L2D extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long l = stack.popLong();
        float f = l;
        stack.pushFloat(f);
    }

}