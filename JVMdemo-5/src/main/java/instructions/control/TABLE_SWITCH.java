package instructions.control;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:43
 * @简介：
 */
public class TABLE_SWITCH implements Instruction {

    private int defaultOffset;
    private int low;
    private int high;
    private int[] jumpOffsets;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.readInt();
        this.low = reader.readInt();
        this.high = reader.readInt();
        int jumpOffsetCount = this.high - this.low + 1;
        this.jumpOffsets = reader.readInts(jumpOffsetCount);
    }

    @Override
    public void execute(Frame frame) {
        int idx = frame.operandStack().popInt();
        int offset;
        if (idx >= this.low && idx <= this.high) {
            offset = this.jumpOffsets[idx - this.low];
        } else {
            offset = this.defaultOffset;
        }
        Instruction.branch(frame, offset);
    }

}