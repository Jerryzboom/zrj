<template>
    <br><br>
    <div style = "text-align: center;">
        <el-input type = "text" v-model = "selectVal" placeholder = "please input" style = "width: 300px;"></el-input>
        <el-button type = "primary" style = "margin-left: 30px;" @click = "search">确认</el-button>
    </div>
    <br><br>
    <!-- 用户表格 -->
    <el-table :data="curPageDate" stripe border style="width: 100%">
    <el-table-column prop="fiId" align = "center" label="序号" width="60" />
    <el-table-column prop="fiName" align = "center" label="姓名" width="80" />
    <el-table-column prop="fiPhoneNumber" align = "center" label="手机号" width = "200" />
    <el-table-column prop="fiAddress" align = "center" label="地址" width = "120" />
    <el-table-column label="操作" align = "center">
            <template #default="scope">
                <el-button type="primary" @click="handleEdit(scope.row)">编辑</el-button>
                <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination 
        :page-size="pageSize"
        :pager-count="11"
        layout="prev, pager, next"
        :total="total"
        @current-change = "change"
    />
                
</template>
<script lang = "ts" setup>
import { ref, onMounted } from "vue"
import axios from "axios"
import router from "@/router"
// 搜索值
const selectVal = ref("")
const search = () => {
    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/factory_info/select_Factory_Info_By_Serach_Value",
        data : {
            searchValue : selectVal.value
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        }).then(res => {
            nums.value = res.data
            total.value = nums.value.length
            console.log(nums.value, total)
            console.log(nums.value, total.value)
            show()
        })
}
// 删除
const handleDelete = (factory) => {
    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/factory_info/delete_Factory_Info_By_fiId",
        data : factory,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            get()
        })
}
// 编辑
const handleEdit = (factory) => {
    router.push( {
        name : "EditFactory",
        query : {
            factory : JSON.stringify(factory)
        }
    })
}
// 分页变量
const total = ref(0)
const nums = ref([])
const curPageDate = ref([])
const curPage = ref(1)
const pageSize= ref(10)
// 获得当前是第几页
const change = (page) => {
    curPage.value = page
    show()
}
// 获得当前页面信息数组
const show = () => {
    // (curPage - 1) * pageSize + 1
    curPageDate.value = []
    for(let i = 0; i < pageSize.value; i += 1) {
        let id = i + (curPage.value - 1) * pageSize.value + 1 - 1
        if(id == total.value) break
        curPageDate.value.push(nums.value[id])
    }
}
const get = () => {
    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/factory_info/select_All_Factory_Info",
        data : {
            
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        }).then(res => {
            nums.value = res.data
            total.value = nums.value.length
            console.log(nums.value, total)
            console.log(nums.value, total.value)
            show()
        })
}
onMounted(() => {
    get()
})
</script>