package instructions.constants.nop;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:12
 * @简介：
 *  最简单的指令表示什么都不做
 */
public class NOP extends InstructionNoOperands {
    @Override
    public void execute(Frame frame){

    }
}
