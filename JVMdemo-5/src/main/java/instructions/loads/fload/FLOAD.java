package instructions.loads.fload;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:25
 * @简介：
 */
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(this.idx);
        frame.operandStack().pushFloat(val);
    }

}