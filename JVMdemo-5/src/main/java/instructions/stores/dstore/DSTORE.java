package instructions.stores.dstore;

import instructions.base.InstructionIndex8;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:30
 * @简介：
 */
public class DSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}