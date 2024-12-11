package instructions.extended;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:49
 * @简介：
 */
public class GOTO_W implements Instruction {

    private int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt();
    }

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }

}