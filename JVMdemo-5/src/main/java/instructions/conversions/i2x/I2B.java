package instructions.conversions.i2x;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:31
 * @简介：
 */
public class I2B extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        int b = (byte) i;
        stack.pushInt(b);
    }

}