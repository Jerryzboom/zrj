package tzb.Utils;

import tzb.Pojo.Client_Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client_Info_TestData {

    private static final Random random = new Random();

    private static final String[] names = {"张三", "李四", "王五", "赵六", "孙七", "周八", "吴九", "郑十", "钱十一", "王十二"};
    private static final String[] addresses = {"上海市", "北京市", "广州市", "深圳市", "成都市", "西安市", "杭州市", "南京市", "武汉市", "长沙市"};
    private static final String[] phoneNumbers = {"13800138000", "13900138000", "13700138000", "13600138000", "13500138000", "13400138000", "13300138000", "13200138000", "13100138000", "13000138000"};
    private static final String[] emails = {"zhangsan@example.com", "lisi@example.com", "wangwu@example.com", "zhaoliu@example.com", "sunqi@example.com", "zhouba@example.com", "wujiu@example.com", "zhengshi@example.com", "qianyiushi@example.com", "wangshier@example.com"};

    public static List<Client_Info> generateRandomClients(int count) {
        List<Client_Info> clients = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String name = names[random.nextInt(names.length)];
            Integer age = 20 + random.nextInt(60); // 年龄在 20 到 79 之间
            String phoneNumber = phoneNumbers[random.nextInt(phoneNumbers.length)];
            String email = emails[random.nextInt(emails.length)];
            String address = addresses[random.nextInt(addresses.length)];
            Integer iiId = 1 + random.nextInt(10); // iiId 在 1 到 10 之间

            Client_Info client = new Client_Info(i + 2, name, age, phoneNumber, email, address);
            clients.add(client);
        }

        return clients;
    }
}
