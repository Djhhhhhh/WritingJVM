package instructions.constants.consts;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:17
 * @简介：
 */
public class LCONST_0  extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushLong(0);
    }
}