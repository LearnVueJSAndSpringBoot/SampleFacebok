import axios from 'axios'


const service = axios.create({
    baseURL: "http://localhost:8080/api/v1/",
})

export default service