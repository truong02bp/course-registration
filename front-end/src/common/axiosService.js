import axios from "axios";
import { API_ENDPOINT } from "../pages/categories/constants";
import store from "../redux/index";
import { changeLoading } from "../reducers/app";
//
// * config axios WITH interceptors * //
//

// request interceptors
const withInterceptors = axios.create();
withInterceptors.interceptors.request.use(
  function (config) {
    //do sth before request is sent
    store.dispatch(changeLoading(true));
    return config;
  },
  function (err) {
    // do sth with request err
    store.dispatch(changeLoading(false));
    return Promise.reject(err);
  }
);

// response interceptors
withInterceptors.interceptors.response.use(
  function (response) {
    //do sth before request is sent
    store.dispatch(changeLoading(false));
    return response;
  },
  function (err) {
    // do sth with request err
    store.dispatch(changeLoading(false));
    return Promise.reject(err);
  }
);

//
// * call api  * //
//

//without token
export const apiInterceptors = async (method, url, data) => {
  return withInterceptors({
    method: method,
    url: `${API_ENDPOINT}/${url}`,
    data: data,
    // headers: { "Access-Control-Allow-Origin": "*" },
  });
};

//with token
export const apiTokenInterceptors = async (method, url, data) => {
  let jwt = localStorage.getItem("jwt") || sessionStorage.getItem("jwt");
  return withInterceptors({
    method: method,
    url: `${API_ENDPOINT}/${url}`,
    data: data,
    headers: {
      Authorization: jwt,
    },
  });
};

// ================================================

//
// * config axios WITHOUT interceptors * //
//

const instance = axios.create();

// without token
export const api = (method, url, data) => {
  return instance({
    method: method,
    url: `${API_ENDPOINT}/${url}`,
    data: data,
  });
};

// with token
export const apiToken = (method, url, data) => {
  let jwt = localStorage.getItem("jwt") || sessionStorage.getItem("jwt");
  return instance({
    method: method,
    url: `${API_ENDPOINT}/${url}`,
    data: data,
    headers: {
      Authorization: jwt,
    },
  });
};
