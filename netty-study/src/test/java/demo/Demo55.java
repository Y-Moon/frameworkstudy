package demo;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class Demo55 {
    public static void main(String[] args) {
        long i = 2149 * 1024 * 256;
        System.out.println(getSize(i,2));
    }

    /**
     * <p>描述：根据大小，动态获取拿到最相近的单位</p>
     *
     * @param size 文件大小（KB）
     * @return java.lang.String
     * @author 王泽强 (zqw.wang@shunwang.com)
     * @date 2022/3/31 15:52
     */
    public static String getSize(long size,int newScale) {
        if (size <= 0) {
            return "0KB";
        }
        final int UNIT_SIZE_1 = 1 << 10;
        final int UNIT_SIZE_2 = UNIT_SIZE_1 - 1;
        String[] unitStr = {"KB", "MB", "GB", "TB"};
        int index = 0;
        long currentSize = size;
        long arrear = 0;
        while (currentSize > UNIT_SIZE_1) {
            //余数
            arrear = currentSize & UNIT_SIZE_2;
            //除法
            currentSize >>= 10;
            ++index;
        }
        BigDecimal finalSize = new BigDecimal(((double) arrear) / UNIT_SIZE_1).setScale(newScale)
                .add(BigDecimal.valueOf(currentSize));
        return finalSize.doubleValue() + unitStr[index];
    }
}
