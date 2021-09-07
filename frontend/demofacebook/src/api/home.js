import request from "@/api/request.js"

function getDataHome() {
    return request({
        url: "/getnewpost",
        methods: "get"
    })
}

function insertDataHome() {
    return request({
        url: "/insertpost",
        methods: "post"
    })
}

export default {
    getDataHome,
    insertDataHome
}