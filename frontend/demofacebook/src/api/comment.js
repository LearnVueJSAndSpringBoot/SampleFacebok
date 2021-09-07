import request from "@/api/request.js";

function insertComment(data) {
    return request.post(`/insertcomment`, data);
}

export default { insertComment };