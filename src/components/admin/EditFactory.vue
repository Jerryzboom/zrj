<template>
    <el-input type = "text" v-model = "fiName" placeholder = "please input 昵称"></el-input>
    <el-input type = "text" v-model = "fiPhoneNumber" placeholder = "please input 手机号"></el-input>
    <el-input type = "text" v-model = "fiAddress" placeholder = "please input 地址"></el-input>
    <el-button type = "primary" @click = "updateFactory">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const factory = JSON.parse(router.currentRoute.value.query.factory)
const fiName = ref(factory.fiName)
const fiPhoneNumber = ref(factory.fiPhoneNumber)
const fiAddress = ref(factory.fiAddress)
const updateFactory = () => {
    const updatefactory = {
        fiId: factory.fiId,
        fiName: fiName.value,
        fiPhoneNumber: fiPhoneNumber.value,
        fiAddress: fiAddress.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/factory_info/update_Factory_Info_By_fiId",
        data : updatefactory,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageFactory"
            })
        })
}
</script>