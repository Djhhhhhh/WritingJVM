package instructions.loads.lload;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:27
 * @简介：
 */
public class LLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(this.idx);
        frame.operandStack().pushLong(val);
    }

}