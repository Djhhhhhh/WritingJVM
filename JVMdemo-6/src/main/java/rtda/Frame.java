package rtda;

import rtda.heap.methodarea.Method;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:25
 * @简介：
 *  帧
 */
public class Frame {
    Frame lower; //作为链表指针

    private LocalVars localVars;  //保存局部变量指针

    private OperandStack operandStack; //保存操作数栈指针

    private Thread thread;

    private Method method;

    private int nextPC;

    public Frame(Thread thread, Method method) {
        this.thread = thread;
        this.method=method;
        this.localVars = new LocalVars(method.maxLocals);
        this.operandStack = new OperandStack(method.maxStack);
    }

    public LocalVars localVars() {
        return localVars;
    }

    public OperandStack operandStack() {
        return operandStack;
    }

    public Thread thread() {
        return this.thread;
    }

    public Method method(){
        return this.method;
    }

    public int nextPC() {
        return this.nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }
}
