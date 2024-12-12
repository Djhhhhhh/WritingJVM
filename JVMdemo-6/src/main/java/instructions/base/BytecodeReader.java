package instructions.base;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/11 13:59
 * @简介：
 *  用于存取字节码 和读取位置
 */
public class BytecodeReader {
    private byte[] codes;

    private int pc;

    public void reset(byte[] codes,int pc){
        this.codes=codes;
        this.pc=pc;
    }

    public int pc(){
        return this.pc;
    }

    public byte readByte(){
        byte code =this.codes[this.pc];
        this.pc++;
        return code;
    }

    public short readShort(){
        byte byte1=readByte();
        byte byte2=readByte();
        return (short)((byte1<<8)|byte2);
    }

    public int readInt(){
        int byte1=this.readByte();
        int byte2=this.readByte();
        int byte3=this.readByte();
        int byte4=this.readByte();
        return (byte1<<24)|(byte2<<16)|(byte3<<8)|(byte4);
    }

    public int[] readInts(int n){
        int[] ints=new int[n];
        for(int i=0;i<n;i++){
            ints[i]=this.readInt();
        }
        return ints;
    }

    public void skipPadding(){
        while(this.pc%4!=0){
            this.readByte();
        }
    }

}
