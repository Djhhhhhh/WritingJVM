package rtda;

import rtda.heap.methodarea.Method;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:11
 * @简介：
 *  线程类
 */
public class Thread {
    private int pc;// Program Counter pc寄存器 又称程序计数器 用于存储下一条需要执行的指令的地址

    private JvmStack stack; //虚拟机栈

    public Thread(){
        this.stack=new JvmStack(1024); //表示 Stack最多可以容纳1024帧
    }

    public int pc() {
        return this.pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void pushFrame(Frame frame) {
        this.stack.push(frame);
    }

    public Frame popFrame() {
        return this.stack.pop();
    }

    public Frame currentFrame() {
        return this.stack.top();
    }

    public Frame topFrame(){
        return this.stack.top();
    }

    public boolean isStackEmpty(){
        return this.stack.isEmpty();
    }

    public Frame newFrame(Method method) {
        return new Frame(this, method);
    }
}
