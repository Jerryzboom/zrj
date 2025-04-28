import axios from "axios"
import qs from "qs"

const instance= axios.create(
    {
        timeout : 5000
    }
)
const errorHandle = (status, info) => {
    switch(status) {
        case 400:
            console.log("��������")
            break
        case 401:
            console.log("��������֤ʧ��")
            break
        case 403:
            console.log("�������ܾ�����")
            break
        case 404:
            console.log("��ַ����")
            break
        case 500:
            console.log("��������������")
            break
        case 502:
            console.log("����������Ӧ")
            break
        default:
            console.log(info)
            break
    }
}
instance.interceptors.request.use(
    config => {
        if(config.method == "post") {
            config.data = qs.stringify(config.data)
        }
        return config
    },
    error => {
        return Promise.reject(error)
    }
)
instance.interceptors.response.use(
    response => {
        return response.status === 200 ? Promise.resolve(response) : Promise.reject(response)
    },
    error => {
        const response = error
        errorHandle(response.status, response.info)
    }
)
export default instance