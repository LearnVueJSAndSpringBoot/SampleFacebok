import request from "@/api/request.js";

function getDataHome() {

    return request.get(`/getnewpost`);
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