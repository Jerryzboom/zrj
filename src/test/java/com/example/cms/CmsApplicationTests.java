package com.example.cms;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tzb.Clever_Medicine;
import tzb.Pojo.*;
import tzb.Service.*;
import tzb.Utils.Client_Info_TestData;
import tzb.Utils.Factory_Info_TestData;
import tzb.Utils.Medicine_Info_TestData;
import tzb.Utils.Operator_Info_TestData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Clever_Medicine.class)
class CmsApplicationTests {

    @Autowired
    private Client_Info_Service_Impl client_info_service;
    @Autowired
    private Factory_Info_Service_Impl factory_info_service;
    @Autowired
    private Identity_Info_Service_Impl identity_info_service;
    @Autowired
    private Operator_Info_Service_Impl operator_info_service;

    @Autowired
    private Medicine_Info_Service_Impl medicine_info_service;
    @Autowired
    private Order_Detail_Service_Impl order_detail_service;
    @Autowired
    private Order_Record_Service_Impl order_record_service;
    @Autowired
    private Store_Info_Service_Impl store_info_service;
    @Autowired
    private Storage_Record_Service_Impl storage_record_service;
    @Test
    void test_client_info() {
        // 生成 100 条随机 Client_Info 数据
        List<Client_Info> testClients = Client_Info_TestData.generateRandomClients(100);

        // 插入测试数据
        for (Client_Info client : testClients) {
            int insertResult = client_info_service.insertClient(client);
            assertEquals(1, insertResult, "插入操作应影响一行");
        }
//        // 创建一个新的 Client_Info 对象
//        Client_Info newClient = new Client_Info(3, "张三", 25, "13800138000", "zhangsan@example.com", "上海市");
//
//        // 插入新的 Client_Info
//        int insertResult = client_info_service.insertClient(newClient);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 根据 ci_id 查询 Client_Info
//        Client_Info queriedClient = client_info_service.selectByCiId(3);
//        assertNotNull(queriedClient, "查询到的 Client_Info 对象不应为空");
//        assertEquals("张三", queriedClient.getCiName(), "查询到的 Client_Info 名称应正确");
//        assertEquals(25, queriedClient.getCiAge(), "查询到的 Client_Info 年龄应正确");
//        assertEquals("13800138000", queriedClient.getCiPhoneNumber(), "查询到的 Client_Info 电话应正确");
//        assertEquals("zhangsan@example.com", queriedClient.getCiEmail(), "查询到的 Client_Info 邮箱应正确");
//        assertEquals("上海市", queriedClient.getCiAddress(), "查询到的 Client_Info 地址应正确");
//
//        // 更新 Client_Info
//        newClient.setCiName("李四");
//        newClient.setCiAge(30);
//        newClient.setCiPhoneNumber("13900139000");
//        newClient.setCiEmail("lisi@example.com");
//        newClient.setCiAddress("北京市");
//        int updateResult = client_info_service.updateClient(newClient);
//        assertEquals(1, updateResult, "更新操作应影响一行");
//
//        // 验证更新结果
//        Client_Info updatedClient = client_info_service.selectByCiId(3);
//        assertNotNull(updatedClient, "更新后的 Client_Info 对象不应为空");
//        assertEquals("李四", updatedClient.getCiName(), "更新后的 Client_Info 名称应正确");
//        assertEquals(30, updatedClient.getCiAge(), "更新后的 Client_Info 年龄应正确");
//        assertEquals("13900139000", updatedClient.getCiPhoneNumber(), "更新后的 Client_Info 电话应正确");
//        assertEquals("lisi@example.com", updatedClient.getCiEmail(), "更新后的 Client_Info 邮箱应正确");
//        assertEquals("北京市", updatedClient.getCiAddress(), "更新后的 Client_Info 地址应正确");
//
//        // 查询所有 Client_Info 列表
//        List<Client_Info> allClients = client_info_service.selectAllClients();
//        assertNotNull(allClients, "查询到的 Client_Info 列表不应为空");
//        assertTrue(allClients.size() > 0, "查询到的 Client_Info 列表应包含至少一个对象");
//
//        // 根据 ci_id 删除 Client_Info
//        int deleteResult = client_info_service.deleteByCiId(3);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//        // 验证删除结果
//        Client_Info deletedClient = client_info_service.selectByCiId(3);
//        assertNull(deletedClient, "删除后的 Client_Info 对象应为空");
    }

    @Test
    void test_factory_info() {
        Factory_Info_TestData f = new Factory_Info_TestData();
        List<Factory_Info> list = f.generateRandomFactories(100);
        for(Factory_Info factory : list) {
            int insertResult = factory_info_service.insertFactory(factory);
        }
//        // 创建一个新的 Factory_Info 对象
//        Factory_Info newFactory = new Factory_Info(1, "工厂A", "13800138000", "上海市");
//
//        // 插入新的 Factory_Info
//        int insertResult = factory_info_service.insertFactory(newFactory);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 根据 fiId 查询 Factory_Info
//        Factory_Info queriedFactory = factory_info_service.selectByFiId(1);
//        assertNotNull(queriedFactory, "查询到的 Factory_Info 对象不应为空");
//        assertEquals("工厂A", queriedFactory.getFiName(), "查询到的 Factory_Info 名称应正确");
//        assertEquals("13800138000", queriedFactory.getFiPhoneNumber(), "查询到的 Factory_Info 电话应正确");
//        assertEquals("上海市", queriedFactory.getFiAddress(), "查询到的 Factory_Info 地址应正确");
//
//        // 更新 Factory_Info
//        newFactory.setFiName("工厂B");
//        newFactory.setFiPhoneNumber("13900139000");
//        newFactory.setFiAddress("北京市");
//        int updateResult = factory_info_service.updateFactory(newFactory);
//        assertEquals(1, updateResult, "更新操作应影响一行");
//
//        // 验证更新结果
//        Factory_Info updatedFactory = factory_info_service.selectByFiId(1);
//        assertNotNull(updatedFactory, "更新后的 Factory_Info 对象不应为空");
//        assertEquals("工厂B", updatedFactory.getFiName(), "更新后的 Factory_Info 名称应正确");
//        assertEquals("13900139000", updatedFactory.getFiPhoneNumber(), "更新后的 Factory_Info 电话应正确");
//        assertEquals("北京市", updatedFactory.getFiAddress(), "更新后的 Factory_Info 地址应正确");
//
//        // 查询所有 Factory_Info 列表
//        List<Factory_Info> allFactories = factory_info_service.selectAllFactories();
//        assertNotNull(allFactories, "查询到的 Factory_Info 列表不应为空");
//        assertTrue(allFactories.size() > 0, "查询到的 Factory_Info 列表应包含至少一个对象");
//
//        // 根据 fiId 删除 Factory_Info
//        int deleteResult = factory_info_service.deleteByFiId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//        // 验证删除结果
//        Factory_Info deletedFactory = factory_info_service.selectByFiId(1);
//        assertNull(deletedFactory, "删除后的 Factory_Info 对象应为空");
    }

    @Test
    void test_identity_info() {
        for(int i = 2; i <= 100; i += 1){
            Identity_Info identity = new Identity_Info(i, "收银员");
            if(i % 2 == 1) identity.setIiType("仓库管理员");
            int insertResult = identity_info_service.insertIdentity(identity);
        }
//        // 创建一个新的 Identity_Info 对象
//        Identity_Info newIdentity = new Identity_Info(1, "类型A");
//
//        // 插入新的 Identity_Info
//        int insertResult = identity_info_service.insertIdentity(newIdentity);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 根据 iiId 查询 Identity_Info
//        Identity_Info queriedIdentity = identity_info_service.selectByIiId(1);
//        assertNotNull(queriedIdentity, "查询到的 Identity_Info 对象不应为空");
//        assertEquals("类型A", queriedIdentity.getIiType(), "查询到的 Identity_Info 类型应正确");
//
//        // 更新 Identity_Info
//        newIdentity.setIiType("类型B");
//        int updateResult = identity_info_service.updateIdentity(newIdentity);
//        assertEquals(1, updateResult, "更新操作应影响一行");
//
//        // 验证更新结果
//        Identity_Info updatedIdentity = identity_info_service.selectByIiId(1);
//        assertNotNull(updatedIdentity, "更新后的 Identity_Info 对象不应为空");
//        assertEquals("类型B", updatedIdentity.getIiType(), "更新后的 Identity_Info 类型应正确");
//
//        // 查询所有 Identity_Info 列表
//        List<Identity_Info> allIdentities = identity_info_service.selectAllIdentities();
//        assertNotNull(allIdentities, "查询到的 Identity_Info 列表不应为空");
//        assertTrue(allIdentities.size() > 0, "查询到的 Identity_Info 列表应包含至少一个对象");
//
//        // 根据 iiId 删除 Identity_Info
//        int deleteResult = identity_info_service.deleteByIiId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//        // 验证删除结果
//        Identity_Info deletedIdentity = identity_info_service.selectByIiId(1);
//        assertNull(deletedIdentity, "删除后的 Identity_Info 对象应为空");
    }

    @Test
    void test_medicine_info() {
        List<Medicine_Info> list = Medicine_Info_TestData.generateMedicineInfoTestData(100);
        for(Medicine_Info medicine : list) {
            int insertResult = medicine_info_service.insertMedicine(medicine);
        }
////         创建一个新的 Medicine_Info 对象
//        Medicine_Info newMedicine = new Medicine_Info(
//                1,
//                "药物A",
//                "10mg",
//                100,
//                LocalDate.of(2024, 9, 11), // 2024年9月11日
//                LocalDate.of(2025, 9, 11), // 2025年9月11日
//                "批号123",
//                1,
//                "类型A",
//                1000,
//                2000
//        );

        // 插入新的 Medicine_Info
//        int insertResult = medicine_info_service.insertMedicine(newMedicine);
//        assertEquals(1, insertResult, "插入操作应影响一行");

        // 根据 miId 查询 Medicine_Info
//        Medicine_Info queriedMedicine = medicine_info_service.selectByMiId(1);
//        assertNotNull(queriedMedicine, "查询到的 Medicine_Info 对象不应为空");
//        assertEquals("药物A", queriedMedicine.getMiName(), "查询到的 Medicine_Info 名称应正确");
//        assertEquals("10mg", queriedMedicine.getMiDose(), "查询到的 Medicine_Info 剂量应正确");
//        assertEquals(100, queriedMedicine.getMiStorageState(), "查询到的 Medicine_Info 存储状态应正确");
//        assertEquals("批号123", queriedMedicine.getMiPiciNumber(), "查询到的 Medicine_Info 批号应正确");
//        assertEquals(1, queriedMedicine.getFiId(), "查询到的 Medicine_Info 工厂ID应正确");
//        assertEquals("类型A", queriedMedicine.getMiType(), "查询到的 Medicine_Info 类型应正确");
//        assertEquals(1000, queriedMedicine.getMiPurchasePrice(), "查询到的 Medicine_Info 进价应正确");
//        assertEquals(2000, queriedMedicine.getMiSalePrice(), "查询到的 Medicine_Info 售价应正确");
//        // 更新 Medicine_Info
//        newMedicine.setMiName("药物B");
//        newMedicine.setMiDose("20mg");
//        newMedicine.setMiStorageState(200);
//        newMedicine.setMiPiciNumber("批号456");
//        newMedicine.setMiType("类型B");
//        newMedicine.setMiPurchasePrice(1500);
//        newMedicine.setMiSalePrice(2500);
//        int updateResult = medicine_info_service.updateMedicine(newMedicine);
//        assertEquals(1, updateResult, "更新操作应影响一行");
////
////        // 验证更新结果
//        Medicine_Info updatedMedicine = medicine_info_service.selectByMiId(1);
//        assertNotNull(updatedMedicine, "更新后的 Medicine_Info 对象不应为空");
//        assertEquals("药物B", updatedMedicine.getMiName(), "更新后的 Medicine_Info 名称应正确");
//        assertEquals("20mg", updatedMedicine.getMiDose(), "更新后的 Medicine_Info 剂量应正确");
//        assertEquals(200, updatedMedicine.getMiStorageState(), "更新后的 Medicine_Info 存储状态应正确");
//        assertEquals("批号456", updatedMedicine.getMiPiciNumber(), "更新后的 Medicine_Info 批号应正确");
//        assertEquals("类型B", updatedMedicine.getMiType(), "更新后的 Medicine_Info 类型应正确");
//        assertEquals(1500, updatedMedicine.getMiPurchasePrice(), "更新后的 Medicine_Info 进价应正确");
//        assertEquals(2500, updatedMedicine.getMiSalePrice(), "更新后的 Medicine_Info 售价应正确");
////
//        // 查询所有 Medicine_Info 列表
//        List<Medicine_Info> allMedicines = medicine_info_service.selectAllMedicines();
//        assertNotNull(allMedicines, "查询到的 Medicine_Info 列表不应为空");
//        assertTrue(allMedicines.size() > 0, "查询到的 Medicine_Info 列表应包含至少一个对象");
////
//        // 根据 miId 删除 Medicine_Info
//        int deleteResult = medicine_info_service.deleteByMiId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//        // 验证删除结果
//        Medicine_Info deletedMedicine = medicine_info_service.selectByMiId(1);
//        assertNull(deletedMedicine, "删除后的 Medicine_Info 对象应为空");
    }

    @Test
    void test_Operator_Info() {
        List<Operator_Info> list = Operator_Info_TestData.generateOperatorInfoTestData(98);
        for(Operator_Info operator : list) {
            int insertResult = operator_info_service.insertOperator(operator);
        }
        // 生成测试数据
//        Operator_Info operator1 = new Operator_Info(1, "张三", "13800138000", "zhangsan@example.com", "password1", "上海市", 1);
//
//        // 插入测试数据
//        int insertResult = operator_info_service.insertOperator(operator1);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 查询所有 Operator_Info 列表
//        List<Operator_Info> allOperators = operator_info_service.selectAllOperators();
//        assertNotNull(allOperators, "查询到的 Operator_Info 列表不应为空");
//        assertTrue(allOperators.size() > 0, "查询到的 Operator_Info 列表应包含至少一个对象");

        // 根据 oiId 查询 Operator_Info
//        Operator_Info queriedOperator = operator_info_service.selectByOiId(1);
//        assertNotNull(queriedOperator, "查询到的 Operator_Info 对象不应为空");
//        assertEquals("张三", queriedOperator.getOiName(), "查询到的 Operator_Info 名称应正确");
//        assertEquals("13800138000", queriedOperator.getOiPhoneNumber(), "查询到的 Operator_Info 电话应正确");
//        assertEquals("zhangsan@example.com", queriedOperator.getOiEmail(), "查询到的 Operator_Info 邮箱应正确");
//        assertEquals("password1", queriedOperator.getOiPassword(), "查询到的 Operator_Info 密码应正确");
//        assertEquals("上海市", queriedOperator.getOiAddress(), "查询到的 Operator_Info 地址应正确");
//        assertEquals(1, queriedOperator.getIiId(), "查询到的 Operator_Info iiId 应正确");
//
        // 更新 Operator_Info
//        Operator_Info updatedOperator = new Operator_Info(1, "李四", "13900139000", "lisi@example.com", "password2", "北京市", 1);
//        int updateResult = operator_info_service.updateOperator(updatedOperator);
//        assertEquals(1, updateResult, "更新操作应影响一行");

        // 验证更新结果
//        Operator_Info verifiedUpdatedOperator = operator_info_service.selectByOiId(1);
//        assertNotNull(verifiedUpdatedOperator, "更新后的 Operator_Info 对象不应为空");
//        assertEquals("李四", verifiedUpdatedOperator.getOiName(), "更新后的 Operator_Info 名称应正确");
//        assertEquals("13900139000", verifiedUpdatedOperator.getOiPhoneNumber(), "更新后的 Operator_Info 电话应正确");
//        assertEquals("lisi@example.com", verifiedUpdatedOperator.getOiEmail(), "更新后的 Operator_Info 邮箱应正确");
//        assertEquals("password2", verifiedUpdatedOperator.getOiPassword(), "更新后的 Operator_Info 密码应正确");
//        assertEquals("北京市", verifiedUpdatedOperator.getOiAddress(), "更新后的 Operator_Info 地址应正确");
//        assertEquals(1, verifiedUpdatedOperator.getIiId(), "更新后的 Operator_Info iiId 应正确");
//
//        // 根据 oiId 删除 Operator_Info
//        int deleteResult = operator_info_service.deleteByOiId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//
//        // 验证删除结果
//        Operator_Info deletedOperator = operator_info_service.selectByOiId(1);
//        assertNull(deletedOperator, "删除后的 Operator_Info 对象应为空");
    }
    @Test
    void test_order_detail() {
        for(int i = 1; i <= 100; i += 1){
            Order_Detail orderDetail = new Order_Detail(i, i, i, 0, 1500);
            Medicine_Info medicine = medicine_info_service.selectByMiId(i);
            orderDetail.setOdPayPrice((i % 4 + 1) * medicine.getMiPurchasePrice());
            int insertResult = order_detail_service.insertOrderDetail(orderDetail);
        }
//        // 生成测试数据
//        Order_Detail orderDetail1 = new Order_Detail(1, 1, 1, 1, 1500);
//
//        // 插入测试数据
//        int insertResult = order_detail_service.insertOrderDetail(orderDetail1);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 查询所有 Order_Detail 列表
//        List<Order_Detail> allOrderDetails = order_detail_service.selectAllOrderDetails();
//        assertNotNull(allOrderDetails, "查询到的 Order_Detail 列表不应为空");
//        assertTrue(allOrderDetails.size() > 0, "查询到的 Order_Detail 列表应包含至少一个对象");
//
//        // 根据 odId 查询 Order_Detail
//        Order_Detail queriedOrderDetail = order_detail_service.selectByOdId(1);
//        assertNotNull(queriedOrderDetail, "查询到的 Order_Detail 对象不应为空");
//        assertEquals(1, queriedOrderDetail.getMiId(), "查询到的 Order_Detail miId 应正确");
//        assertEquals(1, queriedOrderDetail.getFiId(), "查询到的 Order_Detail fiId 应正确");
//        assertEquals(1, queriedOrderDetail.getOdState(), "查询到的 Order_Detail 状态应正确");
//        assertEquals(1500, queriedOrderDetail.getOdPayPrice(), "查询到的 Order_Detail 支付价格应正确");
//
//        // 更新 Order_Detail
//        Order_Detail updatedOrderDetail = new Order_Detail(1, 1, 1, 2, 1600);
//        int updateResult = order_detail_service.updateOrderDetail(updatedOrderDetail);
//        assertEquals(1, updateResult, "更新操作应影响一行");
//
//        // 验证更新结果
//        Order_Detail verifiedUpdatedOrderDetail = order_detail_service.selectByOdId(1);
//        assertNotNull(verifiedUpdatedOrderDetail, "更新后的 Order_Detail 对象不应为空");
//        assertEquals(1, verifiedUpdatedOrderDetail.getMiId(), "更新后的 Order_Detail miId 应正确");
//        assertEquals(1, verifiedUpdatedOrderDetail.getFiId(), "更新后的 Order_Detail fiId 应正确");
//        assertEquals(2, verifiedUpdatedOrderDetail.getOdState(), "更新后的 Order_Detail 状态应正确");
//        assertEquals(1600, verifiedUpdatedOrderDetail.getOdPayPrice(), "更新后的 Order_Detail 支付价格应正确");
//
//        // 根据 odId 删除 Order_Detail
//        int deleteResult = order_detail_service.deleteByOdId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//        // 验证删除结果
//        Order_Detail deletedOrderDetail = order_detail_service.selectByOdId(1);
//        assertNull(deletedOrderDetail, "删除后的 Order_Detail 对象应为空");
    }

    @Test
    void test_order_record() {
        List<Medicine_Info> list = medicine_info_service.selectAllMedicines();
        int j = 12;
        int i = 1;
        for(Medicine_Info medicine : list) {
            Order_Record v = new Order_Record(medicine.getMiId(), medicine.getMiId(), i, LocalDate.of(2023, 10, 1), medicine.getMiPurchasePrice() * i, j);
            j += 2;
            i += 1;
            if(j >= 90) {
                j = 12;
            }
            if(i >= 10) {
                i = 1;
            }
            int insertResult = order_record_service.insertOrderRecord(v);
        }
        // 生成测试数据
//        Order_Record orderRecord1 = new Order_Record(1, 1, 1, LocalDate.of(2023, 10, 1), 1500, 1);
//
//        // 插入测试数据
//        int insertResult = order_record_service.insertOrderRecord(orderRecord1);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 查询所有 Order_Record 列表
//        List<Order_Record> allOrderRecords = order_record_service.selectAllOrderRecords();
//        assertNotNull(allOrderRecords, "查询到的 Order_Record 列表不应为空");
//        assertTrue(allOrderRecords.size() > 0, "查询到的 Order_Record 列表应包含至少一个对象");
//
//        // 根据 orId 查询 Order_Record
//        Order_Record queriedOrderRecord = order_record_service.selectByOrId(1);
//        assertNotNull(queriedOrderRecord, "查询到的 Order_Record 对象不应为空");
//        assertEquals(1, queriedOrderRecord.getMiId(), "查询到的 Order_Record miId 应正确");
//        assertEquals(1, queriedOrderRecord.getCiId(), "查询到的 Order_Record ciId 应正确");
//        assertEquals(LocalDate.of(2023, 10, 1), queriedOrderRecord.getOrSaleDate(), "查询到的 Order_Record 销售日期应正确");
//        assertEquals(1500, queriedOrderRecord.getOrAllPrice(), "查询到的 Order_Record 总价格应正确");
//        assertEquals(1, queriedOrderRecord.getOiId(), "查询到的 Order_Record oiId 应正确");
//
//        // 更新 Order_Record
//        Order_Record updatedOrderRecord = new Order_Record(1, 1, 1, LocalDate.of(2023, 11, 1), 1600, 1);
//        int updateResult = order_record_service.updateOrderRecord(updatedOrderRecord);
//        assertEquals(1, updateResult, "更新操作应影响一行");
//
//        // 验证更新结果
//        Order_Record verifiedUpdatedOrderRecord = order_record_service.selectByOrId(1);
//        assertNotNull(verifiedUpdatedOrderRecord, "更新后的 Order_Record 对象不应为空");
//        assertEquals(1, verifiedUpdatedOrderRecord.getMiId(), "更新后的 Order_Record miId 应正确");
//        assertEquals(1, verifiedUpdatedOrderRecord.getCiId(), "更新后的 Order_Record ciId 应正确");
//        assertEquals(LocalDate.of(2023, 11, 1), verifiedUpdatedOrderRecord.getOrSaleDate(), "更新后的 Order_Record 销售日期应正确");
//        assertEquals(1600, verifiedUpdatedOrderRecord.getOrAllPrice(), "更新后的 Order_Record 总价格应正确");
//        assertEquals(1, verifiedUpdatedOrderRecord.getOiId(), "更新后的 Order_Record oiId 应正确");
//
//        // 根据 orId 删除 Order_Record
//        int deleteResult = order_record_service.deleteByOrId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
//
//        // 验证删除结果
//        Order_Record deletedOrderRecord = order_record_service.selectByOrId(1);
//        assertNull(deletedOrderRecord, "删除后的 Order_Record 对象应为空");
    }

    @Test
    void test_store_info() {
        List<Medicine_Info> list = medicine_info_service.selectAllMedicines();
        int cnt = 1;
        for(Medicine_Info medicine : list){
            Store_Info storeInfo = new Store_Info(cnt, medicine.getMiId(), 0);
            int insertResult = store_info_service.insertStoreInfo(storeInfo);
            cnt += 1;
        }
//        // 生成测试数据
//        Store_Info storeInfo1 = new Store_Info(1, 1, 50);
//
//        // 插入测试数据
//        int insertResult = store_info_service.insertStoreInfo(storeInfo1);
//        assertEquals(1, insertResult, "插入操作应影响一行");
//
//        // 查询所有 Store_Info 列表
//        List<Store_Info> allStoreInfos = store_info_service.selectAllStoreInfos();
//        assertNotNull(allStoreInfos, "查询到的 Store_Info 列表不应为空");
//        assertTrue(allStoreInfos.size() > 0, "查询到的 Store_Info 列表应包含至少一个对象");
//
//        // 根据 siId 查询 Store_Info
//        Store_Info queriedStoreInfo = store_info_service.selectBySiId(1);
//        assertNotNull(queriedStoreInfo, "查询到的 Store_Info 对象不应为空");
//        assertEquals(1, queriedStoreInfo.getMiId(), "查询到的 Store_Info miId 应正确");
//        assertEquals(50, queriedStoreInfo.getSiMiNumber(), "查询到的 Store_Info 数量应正确");
//
//        // 更新 Store_Info
//        Store_Info updatedStoreInfo = new Store_Info(1, 1, 60);
//        int updateResult = store_info_service.updateStoreInfo(updatedStoreInfo);
//        assertEquals(1, updateResult, "更新操作应影响一行");
//
//        // 验证更新结果
//        Store_Info verifiedUpdatedStoreInfo = store_info_service.selectBySiId(1);
//        assertNotNull(verifiedUpdatedStoreInfo, "更新后的 Store_Info 对象不应为空");
//        assertEquals(1, verifiedUpdatedStoreInfo.getMiId(), "更新后的 Store_Info miId 应正确");
//        assertEquals(60, verifiedUpdatedStoreInfo.getSiMiNumber(), "更新后的 Store_Info 数量应正确");
//
//        // 根据 siId 删除 Store_Info
//        int deleteResult = store_info_service.deleteBySiId(1);
//        assertEquals(1, deleteResult, "删除操作应影响一行");
////
////        // 验证删除结果
////        Store_Info deletedStoreInfo = store_info_service.selectBySiId(1);
////        assertNull(deletedStoreInfo, "删除后的 Store_Info 对象应为空");
    }

    @Test
    void test_storage_record() {
        // 生成测试数据
        Storage_Record storageRecord1 = new Storage_Record(1, 1, 1, 1, LocalDate.of(2023, 10, 1), 50);

        // 插入测试数据
        int insertResult = storage_record_service.insertStorageRecord(storageRecord1);
        assertEquals(1, insertResult, "插入操作应影响一行");

        // 查询所有 Storage_Record 列表
        List<Storage_Record> allStorageRecords = storage_record_service.selectAllStorageRecords();
        assertNotNull(allStorageRecords, "查询到的 Storage_Record 列表不应为空");
        assertTrue(allStorageRecords.size() > 0, "查询到的 Storage_Record 列表应包含至少一个对象");

        // 根据 srId 查询 Storage_Record
        Storage_Record queriedStorageRecord = storage_record_service.selectBySrId(1);
        assertNotNull(queriedStorageRecord, "查询到的 Storage_Record 对象不应为空");
        assertEquals(1, queriedStorageRecord.getSiId(), "查询到的 Storage_Record siId 应正确");
        assertEquals(1, queriedStorageRecord.getMiId(), "查询到的 Storage_Record miId 应正确");
        assertEquals(1, queriedStorageRecord.getOiId(), "查询到的 Storage_Record oiId 应正确");
        assertEquals(LocalDate.of(2023, 10, 1), queriedStorageRecord.getSrPurchaseDate(), "查询到的 Storage_Record 采购日期应正确");
        assertEquals(50, queriedStorageRecord.getSrPurchaseNumber(), "查询到的 Storage_Record 采购数量应正确");

        // 更新 Storage_Record
        Storage_Record updatedStorageRecord = new Storage_Record(1, 1, 1, 1, LocalDate.of(2023, 11, 1), 60);
        int updateResult = storage_record_service.updateStorageRecord(updatedStorageRecord);
        assertEquals(1, updateResult, "更新操作应影响一行");

        // 验证更新结果
        Storage_Record verifiedUpdatedStorageRecord = storage_record_service.selectBySrId(1);
        assertNotNull(verifiedUpdatedStorageRecord, "更新后的 Storage_Record 对象不应为空");
        assertEquals(1, verifiedUpdatedStorageRecord.getSiId(), "更新后的 Storage_Record siId 应正确");
        assertEquals(1, verifiedUpdatedStorageRecord.getMiId(), "更新后的 Storage_Record miId 应正确");
        assertEquals(1, verifiedUpdatedStorageRecord.getOiId(), "更新后的 Storage_Record oiId 应正确");
        assertEquals(LocalDate.of(2023, 11, 1), verifiedUpdatedStorageRecord.getSrPurchaseDate(), "更新后的 Storage_Record 采购日期应正确");
        assertEquals(60, verifiedUpdatedStorageRecord.getSrPurchaseNumber(), "更新后的 Storage_Record 采购数量应正确");

        // 根据 srId 删除 Storage_Record
        int deleteResult = storage_record_service.deleteBySrId(1);
        assertEquals(1, deleteResult, "删除操作应影响一行");

        // 验证删除结果
        Storage_Record deletedStorageRecord = storage_record_service.selectBySrId(1);
        assertNull(deletedStorageRecord, "删除后的 Storage_Record 对象应为空");
    }
}

