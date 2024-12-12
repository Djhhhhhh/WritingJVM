package instructions.control.rtn;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.Thread;
import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:21
 * @简介：
 */
public class ARETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        Object ref = currentFrame.operandStack().popRef();
        invokerFrame.operandStack().pushRef(ref);
    }

}