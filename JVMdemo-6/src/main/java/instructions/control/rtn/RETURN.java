package instructions.control.rtn;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:24
 * @简介：
 */
public class RETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.thread().popFrame();
    }

}