<template>
    <el-input type = "text" v-model = "miName" placeholder = "please input 昵称"></el-input>
    <el-input type = "text" v-model = "miDose" placeholder = "please input 剂量"></el-input>
    <el-input type = "text" v-model = "miStorageState" placeholder = "please input 是否有货"></el-input>
    <el-input type = "text" v-model = "miBornDate" placeholder = "please input 生产日期"></el-input>
    <el-input type = "text" v-model = "miExpiry" placeholder = "please input 有效期"></el-input>
    <el-input type = "text" v-model = "miPiciNumber" placeholder = "please input 批次号"></el-input>
    <el-input type = "text" v-model = "fiId" placeholder = "please input 厂家号"></el-input>
    <el-input type = "text" v-model = "miType" placeholder = "please input 类型"></el-input>
    <el-input type = "text" v-model = "miPurchasePrice" placeholder = "please input 进价"></el-input>
    <el-input type = "text" v-model = "miSalePrice" placeholder = "please input 售价"></el-input>
    <el-button type = "primary" @click = "updateMedicine">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const medicine = JSON.parse(router.currentRoute.value.query.medicine)
const miName = ref(medicine.miName)
const miDose = ref(medicine.miDose)
const miStorageState = ref(medicine.miStorageState)
const miBornDate = ref(medicine.miBornDate)
const miExpiry = ref(medicine.miExpiry)
const miPiciNumber = ref(medicine.miPiciNumber)
const fiId = ref(medicine.fiId)
const miType = ref(medicine.miType)
const miPurchasePrice = ref(medicine.miPurchasePrice)
const miSalePrice = ref(medicine.miSalePrice)
const updateMedicine = () => {
    const updatemedicine = {
        miId: medicine.miId,
        miName: miName.value,
        miDose: miDose.value,
        miStorageState: miStorageState.value,
        miBornDate: miBornDate.value,
        miExpiry: miExpiry.value,
        miPiciNumber: miPiciNumber.value,
        fiId: fiId.value,
        miType: miType.value,
        miPurchasePrice: miPurchasePrice.value,
        miSalePrice: miSalePrice.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/medicine_info/update_Medicine_Info_By_miId",
        data : updatemedicine,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageMedicine"
            })
        })
}
</script>