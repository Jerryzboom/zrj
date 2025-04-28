<template>
    <el-input type = "text" v-model = "miId" placeholder = "please input 药品号"></el-input>
    <el-input type = "text" v-model = "fiId" placeholder = "please input 厂家号"></el-input>
    <el-input type = "text" v-model = "odState" placeholder = "please input 是否送达"></el-input>
    <el-input type = "text" v-model = "odPayPrice" placeholder = "please input 总进价"></el-input>
    <el-button type = "primary" @click = "updateDetail">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const order = JSON.parse(router.currentRoute.value.query.order)
const miId = ref(order.miId)
const fiId = ref(order.fiId)
const odState = ref(order.odState)
const odPayPrice = ref(order.odPayPrice)
const updateDetail = () => {
    const updateOrderDetail = {
        odId: order.odId,
        miId: miId.value,
        fiId: fiId.value,
        odState: odState.value,
        odPayPrice: odPayPrice.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/order_detail/update_Order_Detail_By_odId",
        data : updateOrderDetail,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageOrderDetail"
            })
        })
}
</script>