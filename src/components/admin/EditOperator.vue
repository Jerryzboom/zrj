<template>
    <el-input type = "text" v-model = "oiName" placeholder = "please input 昵称"></el-input>
    <el-input type = "text" v-model = "oiPhoneNumber" placeholder = "please input 手机号"></el-input>
    <el-input type = "text" v-model = "oiPassword" placeholder = "please input 密码"></el-input>
    <el-input type = "text" v-model = "oiEmail" placeholder = "please input 邮箱"></el-input>
    <el-input type = "text" v-model = "oiAddress" placeholder = "please input 地址"></el-input>
    <el-input type = "text" v-model = "iiId" placeholder = "please input 类型号"></el-input>
    <el-button type = "primary" @click = "updateOperator">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const operator = JSON.parse(router.currentRoute.value.query.operator)
const oiName = ref(operator.oiName)
const oiPassword = ref(operator.oiPassword)
const oiPhoneNumber = ref(operator.oiPhoneNumber)
const oiEmail = ref(operator.oiEmail)
const oiAddress = ref(operator.oiAddress)
const iiId = ref(operator.iiId)
const updateOperator = () => {
    const updateOperator = {
        oiId: operator.oiId,
        oiName: oiName.value,
        oiPassword : oiPassword.value,
        oiPhoneNumber: oiPhoneNumber.value,
        oiEmail: oiEmail.value,
        oiAddress: oiAddress.value,
        iiId : iiId.value   
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/operator_info/update_Operator_Info_By_oiId",
        data : updateOperator,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageOperator"
            })
        })
}
</script>