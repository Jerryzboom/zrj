package tzb.Utils;

import tzb.Pojo.Medicine_Info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Medicine_Info_TestData {

    private static final String[] MEDICINE_NAMES = {
        "阿司匹林", "布洛芬", "对乙酰氨基酚", "维生素C", "抗生素", "止咳糖浆", "退烧药", "镇痛药", "感冒药", "消炎药"
    };

    private static final String[] DOSE_UNITS = {
        "mg", "g", "ml", "l"
    };

    private static final Random random = new Random();

    public static List<Medicine_Info> generateMedicineInfoTestData(int numberOfEntries) {
        List<Medicine_Info> medicineInfos = new ArrayList<>();

        for (int i = 1; i <= numberOfEntries; i++) {
            String randomName = MEDICINE_NAMES[random.nextInt(MEDICINE_NAMES.length)] + i;
            String randomDose = (10 + random.nextInt(100)) + " " + DOSE_UNITS[random.nextInt(DOSE_UNITS.length)];
            LocalDate randomBornDate = LocalDate.now().minusDays(random.nextInt(365 * 5)); // 最多5年前
            LocalDate randomExpiry = randomBornDate.plusDays(365 * (1 + random.nextInt(5))); // 有效期1到5年

            Medicine_Info medicineInfo = new Medicine_Info(
                    i + 1, // miId
                    randomName, // miName
                    randomDose, // miDose
                    0, // miStorageState
                    randomBornDate, // miBornDate
                    randomExpiry, // miExpiry
                    "批次" + i, // miPiciNumber
                    i, // fiId
                    "类型" + i, // miType
                    100 * i, // miPurchasePrice
                    150 * i // miSalePrice
            );
            medicineInfos.add(medicineInfo);
        }

        return medicineInfos;
    }
}
