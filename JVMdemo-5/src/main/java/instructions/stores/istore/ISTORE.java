package instructions.stores.istore;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:34
 * @简介：
 */
public class ISTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, this.idx);
    }

}