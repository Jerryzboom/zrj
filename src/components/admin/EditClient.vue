<template>
    <el-input type = "text" v-model = "ciName" placeholder = "please input 昵称"></el-input>
    <el-input type = "text" v-model = "ciAge" placeholder = "please input 年龄"></el-input>
    <el-input type = "text" v-model = "ciPhoneNumber" placeholder = "please input 手机号"></el-input>
    <el-input type = "text" v-model = "ciEmail" placeholder = "please input 邮箱"></el-input>
    <el-input type = "text" v-model = "ciAddress" placeholder = "please input 地址"></el-input>
    <el-button type = "primary" @click = "updateClient">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const client = JSON.parse(router.currentRoute.value.query.client)
const ciName = ref(client.ciName)
const ciAge = ref(client.ciAge)
const ciPhoneNumber = ref(client.ciPhoneNumber)
const ciEmail = ref(client.ciEmail)
const ciAddress = ref(client.ciAddress)
const updateClient = () => {
    const updateClient = {
        ciId: client.ciId,
        ciName: ciName.value,
        ciAge: ciAge.value,
        ciPhoneNumber: ciPhoneNumber.value,
        ciEmail: ciEmail.value,
        ciAddress: ciAddress.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/client_info/update_Client_Info_By_ciId",
        data : updateClient,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageClient"
            })
        })
}
</script>