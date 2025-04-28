package tzb.Utils;

import tzb.Pojo.Factory_Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Factory_Info_TestData {

    private static final Random random = new Random();

    private static final String[] names = {"工厂A", "工厂B", "工厂C", "工厂D", "工厂E", "工厂F", "工厂G", "工厂H", "工厂I", "工厂J"};
    private static final String[] addresses = {"上海市", "北京市", "广州市", "深圳市", "成都市", "西安市", "杭州市", "南京市", "武汉市", "长沙市"};
    private static final String[] phoneNumbers = {"13800138000", "13900138000", "13700138000", "13600138000", "13500138000", "13400138000", "13300138000", "13200138000", "13100138000", "13000138000"};

    public static List<Factory_Info> generateRandomFactories(int count) {
        List<Factory_Info> factories = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String name = names[random.nextInt(names.length)];
            String phoneNumber = phoneNumbers[random.nextInt(phoneNumbers.length)];
            String address = addresses[random.nextInt(addresses.length)];

            Factory_Info factory = new Factory_Info(i + 1, name, phoneNumber, address);
            factories.add(factory);
        }

        return factories;
    }
}
