import request from "@/api/request.js"

function getDataHome() {
    return request({
        url: "/getnewpost",
        methods: "get"
    })
}

export default { getDataHome }