package instructions.comparisons.if_icmp;

import instructions.base.Instruction;
import instructions.base.InstructionBranch;
import rtda.Frame;
import rtda.OperandStack;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:38
 * @简介：
 */
public class IF_ICMPLE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1 <= val2) {
            Instruction.branch(frame, this.offset);
        }
    }

}