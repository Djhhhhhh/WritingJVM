package instructions.math.neg;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:20
 * @简介：
 */
public class FNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float val = stack.popFloat();
        stack.pushDouble(-val);
    }

}