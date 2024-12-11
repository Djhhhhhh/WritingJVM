package instructions.comparisons.ifcond;

import instructions.base.Instruction;
import instructions.base.InstructionBranch;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:40
 * @简介：
 */
public class IFGT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (val > 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}