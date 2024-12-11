package instructions.constants.consts;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:15
 * @简介：
 */
public class DCONST_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushDouble(0.0);
    }

}