package instructions.base;

import rtda.Frame;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 13:44
 * @简介：
 *  同一指令 创建同一接口
 */
public interface Instruction {
    void fetchOperands(BytecodeReader bytecodeReader);

    void execute(Frame frame);

    static void branch(Frame frame, int offset) {
        int pc = frame.thread().pc();
        int nextPC = pc + offset;
        frame.setNextPC(nextPC);
    }
}
