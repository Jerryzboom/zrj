Client<template>
    <el-input type = "text" v-model = "miId" placeholder = "please input 药品号"></el-input>
    <el-input type = "text" v-model = "ciId" placeholder = "please input 客户号"></el-input>
    <el-input type = "text" v-model = "orSaleDate" placeholder = "please input 哪一天"></el-input>
    <el-input type = "text" v-model = "orAllPrice" placeholder = "please input 都少钱"></el-input>
    <el-input type = "text" v-model = "oiId" aria-placeholder = "please input 操作人员号"></el-input>
    <el-button type = "primary" @click = "updateRecord">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const order = JSON.parse(router.currentRoute.value.query.order)
const miId = ref(order.miId)
const ciId = ref(order.ciId)
const orSaleDate = ref(order.orSaleDate)
const orAllPrice = ref(order.orAllPrice)
const oiId = ref(order.oiId)
const updateRecord = () => {
    const updateOrderRecord = {
        orId: order.orId,
        miId: miId.value,
        ciId: ciId.value,
        orSaleDate: orSaleDate.value,
        orAllPrice: orAllPrice.value,
        oiId: oiId.value
    }
    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/order_record/update_Order_Record_By_orId",
        data : updateOrderRecord,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageOrderRecord"
            })
        })
}
</script>