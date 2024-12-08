package classfile;

import java.math.BigInteger;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/29 16:29
 * @简介：
 * 定义数据读取方式
 *   JVM定义了u1，u2，u4三种数据类型表示：1字节、2字节、4字节 和 无符号整数
 *   对应关系：
 *     1.u1 and u2 对应Java中 int（4字节）
 *     2.u4        对应Java中 long（8字节）
 */
public class ClassReader {
    //字节存储
    private byte[] data;

    public ClassReader(byte[] data){
        this.data=data;
    }

    public byte[] readBytes(int n){
        return readByte(n);
    }

    /**
     * 读取指定数量的字节
     * @param len 长度
     * @return byte[]
     */
    public byte[] readByte(int len){
        byte[] copy=new byte[len];
        System.arraycopy(data,0,copy,0,len);
        System.arraycopy(data,len,data,0,data.length-len);
        return copy;
    }

    /**
     * 将数据处理为int类型 10进制整数
     * @param val 字节数组
     * @return 整数
     */
    public int byte2int(byte[] val){
        String str_hex=new BigInteger(1,val).toString(16);
        return Integer.parseInt(str_hex,16);
    }

    /**
     * 读取u1数据类型
     * @return u1
     */
    public int readUint8(){
        byte[] val=readByte(1);
        return byte2int(val);
    }

    /**
     * 读取u2数据类型
     * @return u2
     */
    public int readUint16(){
        byte[] val=readByte(2);
        return byte2int(val);
    }

    /**
     * 读取u4数据类型
     * @return u4
     */
    public long readUint32(){
        byte[] val=readByte(4);
        String str_hex=new BigInteger(1,val).toString(16);
        return Long.parseLong(str_hex,16);
    }

    public int readUint32TInteger(){
        byte[] val=readByte(4);
        return new BigInteger(1,val).intValue();
    }

    public float readUint64TFloat(){
        byte[] val=readByte(8);
        return new BigInteger(1,val).floatValue();
    }

    public long readUint64TLong(){
        byte[] val=readByte(8);
        return new BigInteger(1,val).longValue();
    }

    public double readUint64TDouble(){
        byte[] val= readByte(8);
        return new BigInteger(1,val).doubleValue();
    }

    public int[] readUint16s(){
        int n=this.readUint16();
        int[] s=new int[n];
        for (int i = 0; i < n; i++) {
            s[i]=this.readUint16();
        }
        return s;
    }
}
