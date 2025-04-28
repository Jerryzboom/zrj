package tzb.Utils;

import tzb.Pojo.Operator_Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Operator_Info_TestData {

    private static final String[] OPERATOR_NAMES = {
        "张三", "李四", "王五", "赵六", "孙七", "周八", "吴九", "郑十", "钱十一", "王十二"
    };

    private static final String[] PHONE_PREFIXES = {
        "130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
        "140", "141", "142", "143", "144", "145", "146", "147", "148", "149",
        "150", "151", "152", "153", "154", "155", "156", "157", "158", "159",
        "160", "161", "162", "163", "164", "165", "166", "167", "168", "169",
        "170", "171", "172", "173", "174", "175", "176", "177", "178", "179",
        "180", "181", "182", "183", "184", "185", "186", "187", "188", "189",
        "190", "191", "192", "193", "194", "195", "196", "197", "198", "199"
    };

    private static final String[] EMAIL_DOMAINS = {
        "example.com", "test.com", "sample.com", "demo.com", "mydomain.com"
    };

    private static final Random random = new Random();

    public static List<Operator_Info> generateOperatorInfoTestData(int numberOfEntries) {
        List<Operator_Info> operatorInfos = new ArrayList<>();

        for (int i = 1; i <= numberOfEntries; i++) {
            String randomName = OPERATOR_NAMES[random.nextInt(OPERATOR_NAMES.length)];
            String randomPhoneNumber = PHONE_PREFIXES[random.nextInt(PHONE_PREFIXES.length)] + generateRandomDigits(8);
            String randomEmail = "user" + i + "@" + EMAIL_DOMAINS[random.nextInt(EMAIL_DOMAINS.length)];
            String randomPassword = generateRandomPassword(10);
            String randomAddress = "地址" + i;
            Integer randomIiId = random.nextInt(100) + 1; // 1 到 100

            Operator_Info operatorInfo = new Operator_Info(
                    i + 1, // oiId
                    randomName, // oiName
                    randomPhoneNumber, // oiPhoneNumber
                    randomEmail, // oiEmail
                    randomPassword, // oiPassword
                    randomAddress, // oiAddress
                    i + 1 // iiId
            );
            operatorInfos.add(operatorInfo);
        }

        return operatorInfos;
    }

    private static String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Operator_Info> operatorInfos = generateOperatorInfoTestData(98);

        // 打印生成的测试数据
        for (Operator_Info operatorInfo : operatorInfos) {
            System.out.println(operatorInfo);
        }
    }
}
