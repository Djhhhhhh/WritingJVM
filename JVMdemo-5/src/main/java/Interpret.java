import classfile.MemberInfo;
import classfile.attributes.impl.CodeAttribute;
import instructions.Factory;
import instructions.base.BytecodeReader;
import instructions.base.Instruction;
import rtda.Frame;
import rtda.Slot;
import rtda.Thread;
import com.alibaba.fastjson.JSON;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 16:00
 * @简介：
 */
class Interpret {

    Interpret(MemberInfo m) {
        CodeAttribute codeAttr = m.codeAttribute();
        int maxLocals = codeAttr.maxLocals();
        int maxStack = codeAttr.maxStack();
        byte[] byteCode = codeAttr.data();
        Thread thread = new Thread();
        Frame frame = thread.newFrame(maxLocals, maxStack);
        thread.pushFrame(frame);
        loop(thread, byteCode);
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
                System.out.println("寄存器(指令)尚未实现 " + byteToHexString(new byte[]{opcode}));
                break;
            }
            inst.fetchOperands(reader);
            frame.setNextPC(reader.pc());
            System.out.println("寄存器(指令)：" + byteToHexString(new byte[]{opcode}) + " -> " + inst.getClass().getSimpleName() + " => 局部变量表：" + JSON.toJSONString(frame.operandStack().getSlots()) + " 操作数栈：" + JSON.toJSONString(frame.operandStack().getSlots()));            //exec
            inst.execute(frame);
        }

    }
    private static String byteToHexString(byte[] codes) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        for (byte b : codes) {
            int value = b & 0xFF;
            String strHex = Integer.toHexString(value);
            if (strHex.length() < 2) {
                strHex = "0" + strHex;
            }
            sb.append(strHex);
        }
        return sb.toString();
    }

}