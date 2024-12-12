import classfile.MemberInfo;
import classfile.attributes.impl.CodeAttribute;
import instructions.Factory;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.Slot;
import rtda.Thread;
import com.alibaba.fastjson.JSON;
import rtda.heap.methodarea.Class;
import rtda.heap.methodarea.Method;
import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 16:00
 * @简介：
 */
class Interpret {

    Interpret(Method method) {
        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);
        loop(thread, method.code());
    }

    private void loop(Thread thread, byte[] byteCode) {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();

        while (true) {
            //循环
            int pc = frame.nextPC();
            thread.setPC(pc);
            //decode
            reader.reset(byteCode, pc);
            byte opcode = reader.readByte();
            Instruction inst = Factory.newInstruction(opcode);
            if (null == inst) {
                System.out.format("Unsupported opcode：0x%x\n", opcode);
                break;
            }
            inst.fetchOperands(reader);
            frame.setNextPC(reader.pc());
            System.out.format("寄存器(指令)：0x%x -> %s => 局部变量表：%s 操作数栈：%s\n", opcode, inst.getClass().getSimpleName(), JSON.toJSONString(frame.localVars().getSlots()), JSON.toJSONString(frame.operandStack().getSlots()));
            //exec
            inst.execute(frame);
        }

    }

}