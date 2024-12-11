package instructions.stores.istore;

import instructions.base.InstructionNoOperands;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:34
 * @简介：
 */
public class ISTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, 0);
    }

}
