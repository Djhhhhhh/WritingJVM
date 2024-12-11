package instructions.loads.iload;

import instructions.base.InstructionIndex8;
import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:26
 * @简介：
 */
public class ILOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(0);
        frame.operandStack().pushInt(val);
    }
}