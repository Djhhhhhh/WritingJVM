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

    public Frame(int maxLocals, int maxStack){
        this.localVars=new LocalVars(maxLocals);
        this.operandStack=new OperandStack(maxStack);
    }

    public LocalVars localVars(){
        return this.localVars;
    }

    public OperandStack operandStack(){
        return this.operandStack;
    }
}
