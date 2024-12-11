package instructions.comparisons.ifcond;

import instructions.base.Instruction;
import instructions.base.InstructionBranch;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:39
 * @简介：
 */
public class IFEQ extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (0 == val) {
            Instruction.branch(frame, this.offset);
        }
    }
}