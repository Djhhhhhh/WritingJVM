package instructions.stores.dstore;

import instructions.base.InstructionIndex8;
import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:30
 * @简介：
 */
public class DSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 2);
    }

}