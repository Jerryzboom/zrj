<template>
    <el-menu
    class="el-menu-demo"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    @select=""
  >
    <el-menu-item index="1">智慧药房管理与运营系统 v1.0</el-menu-item>
    <el-menu-item index="2">
        <el-dropdown trigger = "click">
            <span class="el-dropdown-link" style = "color: white;">
            新增
            <el-icon class="el-icon--right">
                <arrow-down />
            </el-icon>
            </span>
            <template #dropdown>
            <el-dropdown-menu>
                <el-dropdown-item @click = "uploadVideo">慕课</el-dropdown-item>
                <el-dropdown-item>帖子</el-dropdown-item>
                <el-dropdown-item @click = "changeShowVal">用户</el-dropdown-item>
            </el-dropdown-menu>
            </template>
        </el-dropdown>
    </el-menu-item>
    <el-menu-item index="3">课堂前台</el-menu-item>
    <el-menu-item index="4" style = "margin-left: 1050px;">
        <el-dropdown trigger = "click">
            <span class="el-dropdown-link" style = "color: white;">
            懒羊羊
            <el-icon class="el-icon--right">
                <arrow-down />
            </el-icon>
            </span>
            <template #dropdown>
            <el-dropdown-menu>
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>切换账号</el-dropdown-item>
                <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
            </template>
        </el-dropdown>
    </el-menu-item>
    <el-menu-item index="5">
        <el-icon style = "color: white;"><IceCream /></el-icon>
    </el-menu-item>
    <el-menu-item index="6">
        <el-icon style = "color: white;"><Lock /></el-icon>
    </el-menu-item>
    <el-menu-item index="7">
        <el-dropdown>
            <span class="el-dropdown-link" style = "color: white;">
                <el-icon style = "color: white;"><Refresh /></el-icon>
            <el-icon class="el-icon--right">
                <arrow-down />
            </el-icon>
            </span>
            <template #dropdown>
            <el-dropdown-menu>
                <el-dropdown-item>蓝色</el-dropdown-item>
                <el-dropdown-item>绿色</el-dropdown-item>
                <el-dropdown-item>橙色</el-dropdown-item>
            </el-dropdown-menu>
            </template>
        </el-dropdown>
    </el-menu-item>
    </el-menu>
    <el-row>
        <el-col :span = "3">
            <el-menu
            :default-active="menuVal"
            class="el-menu-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            @select="changeMenu"
        >
            <el-menu-item index="1">客户管理</el-menu-item>
            <el-menu-item index="2">厂家管理</el-menu-item>
            <el-menu-item index="3">药品管理</el-menu-item>
            <el-menu-item index="4">操作人员类型管理</el-menu-item>
            <el-menu-item index="5">操作人员详细信息管理</el-menu-item>
            <el-menu-item index="6">订单管理</el-menu-item>
            <el-menu-item index="7">库存管理</el-menu-item>
            <el-menu-item index="8">销售单管理</el-menu-item>
            </el-menu>
            <div style = "background-color: lightslategray; height: 400px;"></div>
        </el-col>
        <div style = "width: 500px; height: 300px; border: 1px solid lightblue; box-shadow: 0 0 10px 2px #bdcee0; position: absolute; left: 800px; top: 100px; z-index: 9999; text-align: center; background-color: antiquewhite;" v-show = "showVal">
            <br>
            <h3>注册账号信息</h3>
            <el-input v-model="userName" style="width: 240px" placeholder="请输入用户名" />
            <br>
            <br>
            <el-input v-model="passWord" style="width: 240px" placeholder="请输入密码" />
            <br><br>
            <el-button type = "primary" @click = "addUser">确认</el-button>
        </div>
        <input type = "file" ref = "fileInput" style = "display: none;" @change = "handleFileChange" name = "video"> 
        <el-col :span = "21">
            <!-- <div style = "background-color: lightslategray; height: 50px;">
                
            </div> -->
            <router-view></router-view>
        </el-col>
    </el-row>
</template>

<script lang="ts" setup>
import { ref , onMounted} from 'vue'
import { ArrowDown } from '@element-plus/icons-vue'
import axios from "axios"
import router from "@/router"
const fileInput = ref(null)
const uploadVideo = () => {
    fileInput.value.click()
}
const handleFileChange = (event) => {
    console.log(event, typeof(event))
    const file = event.target.files[0];
    axios( {
        method : "post",
        url : "/ClerverClass_war/videoResourceStoraging",
        data : {
            video : file,
            voCreateDate : new Date()
        },
        headers: {
            'Content-Type': 'multipart/form-data'
        },
        }).then(res => {
            window.location.reload
        })
}
const showVal = ref(false)
const changeShowVal = () => {
    showVal.value = !showVal.value
    console.log("user")
}
const userName = ref("")
const passWord = ref("")
const addUser = () => {
    if(userName.value == "" || passWord.value == "") {
        alert("请输入用户名和密码")
    } else {
        axios( {
            method : "post",
            url : "/ClerverClass_war/resourceUserAndAdminStoraging",
            data : {
                type : "register",
                who : "user",
                userName : userName.value,
                passWord : passWord.value
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            }).then(res => {
                alert("宝宝好厉害哦")
                showVal.value = !showVal.value
                window.location.reload()
            })
        }
}
// 菜单默认选中变量
const activeIndex = ref('1')
const menuVal = ref('1')

// 改变左侧菜单方法
const changeMenu = (index) => {
    console.log(index)
    menuVal.value = index;
    showMain()
}
// show main 页面信息
const showMain = () => {
    console.log(menuVal.value)
    console.log("fffffffffffffff")
    switch(menuVal.value) {
        case "1":
            // 客户管理
            console.log("fffffffffffffffffffffff")
            router.push({
                name : "ManageClient"
            })
            break 
        case "2":
            router.push({
                name : "ManageFactory"
            })
            break 
        case "3":
            router.push({
                name : "ManageMedicine"
            })
            break
        case "4":
            router.push( {
                name : "ManageIdentity"
            })
            break 
        case "5":
            router.push( {
                name : "ManageOperator"
            })
            break
        case "6":
            router.push( {
                name : "ManageOrderDetail"
            })
            break 
        case "7":
            router.push( {
                name : "ManageStore"
            })
            break
        case "8":
            router.push( {
                name : "ManageOrderRecord"
            })
            break
        default:
            break 
    }
}

// shaniao 钩子函数
onMounted(() => {
    console.log(window.location.href)
    console.log("fafafaf")
    showMain()
})
</script>

<style scoped>
.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;

}
</style>