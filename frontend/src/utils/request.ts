import axios  from "axios"; 

const service = axios.create(
    {
        baseURL:'http://localhost:8080/user/register'
    }
);

service.interceptors.request.use(config=>{
    return config
}
)

service.interceptors.response.use(
    response=>{
        return response
    },err=>{
        return Promise.reject(err)
    }
);
export default service;