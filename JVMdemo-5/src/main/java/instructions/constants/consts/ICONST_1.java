package instructions.constants.consts;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:16
 * @简介：
 */
public class ICONST_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(1);
    }
}