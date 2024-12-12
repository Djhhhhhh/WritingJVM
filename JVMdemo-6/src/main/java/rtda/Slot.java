package rtda;

import lombok.Data;
import rtda.heap.methodarea.Object;

/**
 * @Author: _Djhhh
 * @Date: 2024/12/10 13:32
 * @简介：
 *  定义插槽，可以表示int值或者一个引用值
 */
@Data
public class Slot {
    public int num;

    public Object ref;
}
