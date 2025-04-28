import { componentSizeMap } from "element-plus"
import { createRouter, createWebHashHistory } from "vue-router"
const routes = [
    {
        path : "/login",
        name : "Login",
        component : () => import("../components/Login.vue")
    },
    {
        path : "/adminhomePage",
        name : "AdminHomePage",
        component : () => import("@/components/admin/HomePage.vue"),
        children : [
            {
                path : "manageOrderRecord",
                name : "ManageOrderRecord",
                component : () => import("@/components/admin/ManageOrderRecord.vue")
            },
            {
                path : "editOrderRecord",
                name : "EditOrderRecord",
                component : () => import("@/components/admin/EditOrderRecord.vue")
            },
            {
                path : "manageStore",
                name : "ManageStore",
                component : () => import("@/components/admin/ManageStore.vue")
            },
            {
                path : "editStore",
                name : "EditStore",
                component : () => import("@/components/admin/EditStore.vue")
            },
            {
                path : "manageOrderDetail",
                name : "ManageOrderDetail",
                component : () => import("@/components/admin/ManageOrderDetail.vue")
            },
            {
                path : "editOrderDetail",
                name : "EditOrderDetail",
                component : () => import("@/components/admin/EditOrderDetail.vue")
            },
            {
                path : "manageOperator",
                name : "ManageOperator",
                component : () => import("@/components/admin/ManageOperator.vue")
            },
            {
                path : "editOperator",
                name : "EditOperator",
                component : () => import("@/components/admin/EditOperator.vue")
            },
            {
                path : "manageIdentity",
                name : "ManageIdentity",
                component : () => import("@/components/admin/ManageIdentity.vue")
            },
            {
                path : "editIdentity",
                name : "EditIdentity",
                component : () => import("@/components/admin/EditIdentity.vue")
            },
            {
                path : "manageMedicine",
                name : "ManageMedicine",
                component : () => import("@/components/admin/ManageMedicine.vue")
            },
            {
                path : "editMedicine",
                name : "EditMedicine",
                component : () => import("@/components/admin/EditMedicine.vue")
            },
            {
                path : "manageFactory",
                name : "ManageFactory",
                component : () => import("@/components/admin/ManageFactory.vue")
            },
            {
                path : "editFactory",
                name : "EditFactory",
                component : () => import("@/components/admin/EditFactory.vue")
            },
            {
                path : "manageClient",
                name : "ManageClient",
                component : () => import("@/components/admin/ManageClient.vue")
            },
            {
                path : "editClient",
                name : "EditClient",
                component : () => import("@/components/admin/EditClient.vue")
            },
            {
                path : "insertClient",
                name : "InsertClient",
                component : () => import("@/components/admin/InsertClient.vue")
            },
            {
                path : "likeMessage",
                name : "LikeMessage",
                component : () => import("@/components/admin/LikeMessage.vue")
            }
        ]
    },
    {
        path : "/register",
        name : "Register",
        component : () => import("@/components/Register.vue")
    },
    {
        path : '/',
        redirect : '/adminHomePage'
    }
]

const router = createRouter( {
    history : createWebHashHistory(),
    routes
})

export default router