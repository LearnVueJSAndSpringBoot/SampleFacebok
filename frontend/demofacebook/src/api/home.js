import request from "@/api/request.js";

function getDataHome() {
    return request.get(`/getnewpost`);
}

function insertDataHome(formPost) {
    return request.post(`/insertpost`, formPost)
}

export default {
    getDataHome,
    insertDataHome
}