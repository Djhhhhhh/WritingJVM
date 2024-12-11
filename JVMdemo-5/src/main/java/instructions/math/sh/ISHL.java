package instructions.math.sh;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:23
 * @简介：
 */
public class ISHL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int s = v2 & 0x1f;
        int res = v1 << s;
        stack.pushInt(res);
    }

}