package instructions.constants.consts;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:14
 * @简介：
 *  把null值放入操作栈中
 */
public class ACONST_NULL extends InstructionNoOperands {
    @Override
    public void execute(Frame frame){
        frame.operandStack().pushRef(null);
    }
}
