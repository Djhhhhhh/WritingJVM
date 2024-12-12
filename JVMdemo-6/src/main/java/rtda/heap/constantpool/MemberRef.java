package rtda.heap.constantpool;

import classfile.constantpool.impl.ConstantMemberRefInfo;

import java.util.Map;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/12 20:35
 * @简介：
 */
public class MemberRef extends SymRef{
    public String name;
    public String descriptor;

    public void  copyMemberRefInfo(ConstantMemberRefInfo constantMemberRefInfo){
        this.className=constantMemberRefInfo.className();
        Map<String,String> map=constantMemberRefInfo.nameAndDescriptor();
        this.name=map.get("name");
        this.descriptor =map.get("_type");
    }

    public String name(){
        return this.name;
    }

    public String description(){
        return this.descriptor;
    }
}
