package instructions.loads.iload;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:26
 * @简介：
 */
public class ILOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(this.idx);
        frame.operandStack().pushInt(val);
    }
}