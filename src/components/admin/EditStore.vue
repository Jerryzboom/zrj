<template>
    <el-input type = "text" v-model = "miId" placeholder = "please input 药品号"></el-input>
    <el-input type = "text" v-model = "siMiNumber" placeholder = "please input 库存量"></el-input>
    <el-button type = "primary" @click = "updateStore">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const store = JSON.parse(router.currentRoute.value.query.store)
const miId = ref(store.miId)
const siMiNumber = ref(store.siMiNumber)
const updateStore = () => {
    const updateStore = {
        siId: store.siId,
        miId: miId.value,
        siMiNumber: siMiNumber.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/store_info/update_Store_Info_By_siId",
        data : updateStore,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageStore"
            })
        })
}
</script>