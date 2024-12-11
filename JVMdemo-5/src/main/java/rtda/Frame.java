package rtda;

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

    private int nextPC;

    public Frame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
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

    public int nextPC() {
        return this.nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }
}
