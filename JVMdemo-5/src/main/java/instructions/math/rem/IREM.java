package instructions.math.rem;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:22
 * @简介：
 */
public class IREM extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if (v2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int res = v1 % v2;
        stack.pushInt(res);
    }

}