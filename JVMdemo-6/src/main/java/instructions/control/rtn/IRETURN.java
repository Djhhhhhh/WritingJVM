package instructions.control.rtn;

import instructions.base.InstructionNoOperands;
import rtda.Frame;
import rtda.Thread;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:23
 * @简介：
 */
public class IRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        int val = currentFrame.operandStack().popInt();
        invokerFrame.operandStack().pushInt(val);
    }

}