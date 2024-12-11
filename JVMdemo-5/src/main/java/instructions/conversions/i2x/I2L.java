package instructions.conversions.i2x;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:32
 * @简介：
 */
public class I2L extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        long l = i;
        stack.pushLong(l);
    }

}