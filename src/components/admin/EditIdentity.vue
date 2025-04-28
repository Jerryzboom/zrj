<template>
    <el-input type = "text" v-model = "iiType" placeholder = "please input 类型"></el-input>
    <el-button type = "primary" @click = "updateIdentity">确认</el-button>
</template>
<script lang = "ts" setup>
import { ref } from "vue"
import router from "@/router"
import axios from "axios"
const identity = JSON.parse(router.currentRoute.value.query.identity)
const iiType = ref(identity.iiType)
const updateIdentity = () => {
    const updateidentity = {
        iiId: identity.iiId,
        iiType : iiType.value
    }

    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/identity_info/update_Identity_Info_By_iiId",
        data : updateidentity,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            router.push( {
                name : "ManageIdentity"
            })
        })
}
</script>