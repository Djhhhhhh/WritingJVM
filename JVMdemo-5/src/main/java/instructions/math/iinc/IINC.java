package instructions.math.iinc;

import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.LocalVars;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 15:18
 * @简介：
 */
public class IINC implements Instruction {

    public int idx;
    public int constVal;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
        this.constVal = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        LocalVars vars = frame.localVars();
        int val = vars.getInt(this.idx);
        val += this.constVal;
        vars.setInt(this.idx, val);
    }
}