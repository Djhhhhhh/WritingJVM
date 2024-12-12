package instructions.references;

import instructions.base.InstructionIndex16;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 21:11
 * @简介：
 */
public class INVOKE_SPECIAL  extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().popRef();
    }

}