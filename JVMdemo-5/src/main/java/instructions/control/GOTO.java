package instructions.control;

import instructions.base.Instruction;
import instructions.base.InstructionBranch;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:42
 * @简介：
 */
public class GOTO extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }
}