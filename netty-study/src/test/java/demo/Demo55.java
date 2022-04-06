package demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.IntStream;

public class Demo55 {
    public static void main(String[] args) {
        long i = 2149 * 1024 * 256;
        System.out.println(getSize(i,2));
    }
    @Test
    public void testDemo1() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.160.179:6033/gamelife_hotel?serverTimezone=UTC&characterEncoding=UTF-8", "defend_develop_sec", "defend_develop_sec");
        final Statement statement = connection.createStatement();

    }
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
