package instructions.loads.aload;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:21
 * @简介：
 */
public class ALOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(this.idx);
        frame.operandStack().pushRef(ref);
    }

}