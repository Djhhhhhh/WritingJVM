package classfile;

import java.math.BigInteger;

/**
 * @Author: _Djhhh
 * @Date: 2024/11/29 16:29
 */
public class ClassReader {
    private byte[] data;
    public ClassReader(byte[] data){
        this.data=data;
    }
    public byte[] readBytes(int n){
        return readByte(n);
    }
    public byte[] readByte(int len){
        byte[] copy=new byte[len];
        System.arraycopy(data,0,copy,0,len);
        System.arraycopy(data,len,data,0,data.length-len);
        return copy;
    }
    public int byte2int(byte[] val){
        String str_hex=new BigInteger(1,val).toString(16);
        return Integer.parseInt(str_hex);
    }
    public int readUint8(){
        byte[] val=readByte(1);
        return byte2int(val);
    }
    public int readUint16(){
        byte[] val=readByte(2);
        return byte2int(val);
    }
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
