package instructions.comparisons.dcmp;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:34
 * @简介：
 */
public class DCMPL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dcmp(frame, false);
    }

}