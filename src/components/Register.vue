<template>
<div id = "background" style = "text-align: center;">
    <br>        <br>        <br>        <br>        <br>        <br>        <br>        <br>        <br>
    <h1>智慧课堂</h1>
    <h4>心之来</h4>
    <div style = "box-shadow: 0 0 10px 2px #bdcee0; width: 40%; margin-left: 565px;">
        <h3>注册账号信息</h3>
        <el-input v-model="userName" style="width: 240px" placeholder="请输入用户名" />
        <br>
        <br>
        <el-input v-model="passWord" style="width: 240px" placeholder="请输入密码" />
        <div class="my-2 flex items-center text-sm">
        <el-radio-group v-model="radioVal" class="ml-4">
        <el-radio value="user">用户</el-radio>
        <el-radio value="admin">管理员</el-radio>
        </el-radio-group>
        <br>
        <el-button type="primary" @click = "checkRegister" style = "display: inline-block;">注册</el-button>
        <router-link to = "/login" style = "margin-left: 200px; text-decoration: none;">已有账号?</router-link>
    </div>
  </div>
</div>
</template>

<script lang = "ts" setup>
import { ref } from "vue"
import axios from "axios"
import router from "@/router";

// 选了哪个单选框
const radioVal = ref('user')

// 注册信息
const userName = ref('')
const passWord = ref('')

// 检测注册 
const checkRegister = () => {
    if(userName.value == "" || passWord.value == "") {
        alert("请输入用户名和密码")
    } else {
        axios( {
            method : "post",
            url : "/ClerverClass_war/resourceUserAndAdminStoraging",
            data : {
                type : "register",
                who : radioVal.value,
                userName : userName.value,
                passWord : passWord.value
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            }).then(res => {
                console.log("ok")
                if(res.data > 0) {
                    router.push({
                        name : "Login",
                        query : {
                            who : radioVal.value,
                            account : res.data
                        }
                    })
                } else {
                    alert("注册失败")
                }
            })
        }
}
</script>

<style scoped>
#background{
  background:url("../image/background.jpg");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;
}

</style>
