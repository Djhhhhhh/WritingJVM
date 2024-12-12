package instructions.comparisons.if_acmp;

import instructions.base.Instruction;
import instructions.base.InstructionBranch;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:36
 * @简介：
 */
public class IF_ACMPNE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        if (!_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}