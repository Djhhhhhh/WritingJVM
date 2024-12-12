package instructions.loads.dload;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:24
 * @简介：
 */
public class DLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(this.idx);
        frame.operandStack().pushDouble(val);
    }

}