<template>
    <div id = "background" style = "text-align: center;">
        <br>        <br>        <br>        <br>        <br>        <br>        <br>        <br>        <br>
        <h1>智慧课堂</h1>
        <h4>心之来</h4>
        <div style = "box-shadow: 0 0 10px 2px #bdcee0; width: 40%; margin-left: 565px;">
            <h3>登录账号</h3>
            <el-input v-model="account" style="width: 240px" placeholder="请输入账号" />
            <br>
            <br>
            <el-input v-model="passWord" style="width: 240px" placeholder="请输入密码" />
            <div class="my-2 flex items-center text-sm">
            <el-radio-group v-model="radioVal" class="ml-4">
            <el-radio value="user">用户</el-radio>
            <el-radio value="admin">管理员</el-radio>
            </el-radio-group>
            </div>
            <br>
            <el-button type="primary" @click = "checkLogin" style = "display: inline-block;">登录</el-button>
            <router-link to = "/register" style = "margin-left: 200px; text-decoration: none;">还没有账号?</router-link>
        </div>
    </div>
</template>

<script lang = "ts" setup>
import { ref, onMounted } from "vue"
import axios from "axios"
import router from "../router";

// 选了哪个单选框
const radioVal = ref(router.currentRoute.value.query.who)

// 登录信息
const account = ref(router.currentRoute.value.query.Account)
const passWord = ref('')

// 检测登录
const checkLogin = () => {
    if(account.value == "" || passWord.value == "") {
        alert("请输入账号和密码")
    } else {
        axios( {
            method : "post",
            url : "/ClerverClass_war/resourceUserAndAdminStoraging",
            data : {
                type : "login",
                who : radioVal.value,
                account : account.value,
                passWord : passWord.value
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            }).then(res => {
                console.log(res.data)
                if(res.data < 0) alert("账号或密码错误")
                else {
                    let urlName = "Admin" + "HomePage"
                    if(radioVal.value == "user") urlName = "User" + "HomePage"
                    router.push( {
                        name : urlName,
                        query : {
                            account : res.data
                        }
                    })
                }
            })
        }
}
onMounted(() => {
    
})
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
