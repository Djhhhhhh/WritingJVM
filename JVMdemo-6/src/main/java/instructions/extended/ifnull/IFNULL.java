package instructions.extended.ifnull;

import instructions.base.Instruction;
import instructions.base.InstructionBranch;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:51
 * @简介：
 */
public class IFNULL extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack().popRef();
        if (null == ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}