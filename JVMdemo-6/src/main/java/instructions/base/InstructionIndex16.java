package instructions.base;

import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 14:22
 * @简介：
 */
public class InstructionIndex16 implements Instruction {

    protected int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }

}