import request from "@/api/request.js";

function getDataSearch(data) {
    return request.post(`/searchpost`, data);
}
export default {
    getDataSearch
}