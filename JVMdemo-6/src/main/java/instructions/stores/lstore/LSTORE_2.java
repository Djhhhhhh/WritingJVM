package instructions.stores.lstore;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:34
 * @简介：
 */
public class LSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, 2);
    }

}
