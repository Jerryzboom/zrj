import axios from "axios"
const api = {
    sendPost(url, data) {
        axios( {
            method : "post",
            url : url,
            data : data,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(res => {
            console.log(res.data)
            return res.data
        }).catch(function (error) {
            console.log(error)
            return null
        })
    }
}
export default api