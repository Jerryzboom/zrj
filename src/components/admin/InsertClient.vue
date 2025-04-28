<template>
    <el-input type = "text" v-model = "ciName" placeholder = "please input 昵称"></el-input>
    <el-input type = "text" v-model = "ciAge" placeholder = "please input 年龄"></el-input>
    <el-input type = "text" v-model = "ciPhoneNumber" placeholder = "please input 手机号"></el-input>
    <el-input type = "text" v-model = "ciEmail" placeholder = "please input 邮箱"></el-input>
    <el-input type = "text" v-model = "ciAddress" placeholder = "please input 地址"></el-input>
    <el-button type = "primary" @click = "InsertClient">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const ciName = ref("")
const ciAge = ref("")
const ciPhoneNumber = ref("")
const ciEmail = ref("")
const ciAddress = ref("")
const InsertClient = () => {
    const insertClient = {
        ciId: '0',
        ciName: ciName.value,
        ciAge: ciAge.value,
        ciPhoneNumber: ciPhoneNumber.value,
        ciEmail: ciEmail.value,
        ciAddress: ciAddress.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/client_info/insertClient",
        data : insertClient,
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