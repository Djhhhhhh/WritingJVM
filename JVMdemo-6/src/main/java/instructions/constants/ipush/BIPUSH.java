package instructions.constants.ipush;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:19
 * @简介：
 */
public class BIPUSH implements Instruction {

    private byte val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(val);
    }

}