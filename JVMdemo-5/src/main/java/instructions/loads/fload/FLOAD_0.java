package instructions.loads.fload;

import instructions.base.InstructionIndex8;
import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:25
 * @简介：
 */
public class FLOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(0);
        frame.operandStack().pushFloat(val);
    }

}