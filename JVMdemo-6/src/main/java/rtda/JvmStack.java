package rtda;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:18
 * @简介：
 *  Java虚拟机栈
 */
public class JvmStack {

    private int maxSize; // 栈的容量 最多可以容纳的帧数

    private int size; //当前大小

    private Frame _top;  //保存栈顶指针

    public JvmStack(int maxSize){ //
        this.maxSize=maxSize;
    }

    /**
     * 入栈操作
     * @param frame 入栈的帧
     */
    public void push(Frame frame){
        if(this.size>this.maxSize){
            throw new StackOverflowError();  //扔出栈溢出异常
        }
        if(this._top!=null){
            frame.lower=this._top;
        }
        this._top=frame;
        this.size++;
    }

    /**
     * 弹出栈内元素
     * @return frame
     */
    public Frame pop() {
        if (this._top == null) {
            throw new RuntimeException("JVM stack is empty!");
        }
        Frame top = this._top;
        this._top = top.lower;
        top.lower = null;
        this.size--;

        return top;
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public Frame top(){
        if (this._top == null){
            throw new RuntimeException("JVM stack is empty!");
        }
        return this._top;
    }

    public boolean isEmpty(){
        return this._top == null;
    }
}
