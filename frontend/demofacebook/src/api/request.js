import axios from "axios";

const service = axios.create({
    baseURL: "http://localhost:8080/api/v1", // api的base_url
    headers: {
        "Content-type": "application/json",
    },
});
export default service;