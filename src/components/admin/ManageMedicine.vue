<template>
    <br><br>
    <div style = "text-align: center;">
        <el-input type = "text" v-model = "selectVal" placeholder = "please input" style = "width: 300px;"></el-input>
        <el-button type = "primary" style = "margin-left: 30px;" @click = "search">确认</el-button>
    </div>
    <br><br>
    <!-- 用户表格 -->
    <el-table :data="curPageDate" stripe border style="width: 100%">
    <el-table-column prop="miId" align = "center" label="序号" width="60" />
    <el-table-column prop="miName" align = "center" label="药品名" width="200" />
    <el-table-column prop="miDose" align = "center" label="剂量" width = "80" />
    <el-table-column prop="miStorageState" align = "center" label="存货量" width = "60" />
    <el-table-column prop="miBornDate" align = "center" label="生产日期" width = "100" />
    <el-table-column prop="miExpiry" align = "center" label="有效期" width = "100" />
    <el-table-column prop="miPiciNumber" align = "center" label="批次号" width = "100" />
    <el-table-column prop="fiId" align = "center" label="厂家号" width = "80" />
    <el-table-column prop="miType" align = "center" label="类型" width = "80" />
    <el-table-column prop="miPurchasePrice" align = "center" label="进价" width = "80" />
    <el-table-column prop="miSalePrice" align = "center" label="售价" width = "80" />
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
        url : "http://localhost:9421/tzb/medicine_info/select_Medicine_Info_By_Serach_Value",
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
const handleDelete = (medicine) => {
    axios( {
        method : "post",
        url : "http://localhost:9421/tzb/medicine_info/delete_Medicine_Info_By_miId",
        data : medicine,
        headers: {
            'Content-Type': 'application/json'
        },
        }).then(res => {
            get()
        })
}
// 编辑
const handleEdit = (medicine) => {
    router.push( {
        name : "EditMedicine",
        query : {
            medicine : JSON.stringify(medicine)
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
        url : "http://localhost:9421/tzb/medicine_info/select_All_Medicine_Info",
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