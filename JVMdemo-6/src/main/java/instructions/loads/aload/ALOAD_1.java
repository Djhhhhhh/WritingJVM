package instructions.loads.aload;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:23
 * @简介：
 */
public class ALOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(1);
        frame.operandStack().pushRef(ref);
    }

}