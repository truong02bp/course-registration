//api endpoint
export const API_ENDPOINT = process.env.REACT_APP_API;

//action
export const FETCH_SUBJECTS_SUCCESS = "FETCH_SUBJECTS_SUCCESS";
export const FETCH_SUJBECTS_FAILED = "FETCH_SUJBECTS_FAILED";
export const UPDATE_CART = "UPDATE_CART";
export const SHOW_SUBJECT_LIST = "SHOW_SUBJECT_LIST";
export const SHOW_CHOSEN_SUBJECT = "SHOW_CHOSEN_SUBJECT";
export const DELETE_ALL_FROM_CART = "DELETE_ALL_FROM_CART";

//message
// * success * //
export const ADD_TO_CART_SUCCESSFUL = "Add to cart successfully";
export const SAVE_SUCCESSFUL = "Saved to database";
export const LOGIN_SUCCESSFUL = "Login successfully";
export const UPDATED_SUCCESSFUL = "Updated successfully";
// * error * //
export const LOGIN_FAILED = "Invalid user !";
export const MATCH_PASSWORD_FAILED = "New password not matched !";
export const WRONG_PASSWORD = "Wrong password !";
export const SAME_PASSWORD = "New password cannot be the same as old password !";
export const VALIDATE_PASSWORD = "At least 4 char (a-z A-Z 0-9) !"

//day
const currentYear = new Date().getUTCFullYear();
const currentMonth = new Date().getUTCMonth();
const currentDate = new Date().getUTCDate();
export const START_DAY = new Date(2020, 8, 7).getTime();
export const CURRENT_DAY = new Date(currentYear, currentMonth, currentDate).getTime();
export const totalWeeks = 20;

//url
export const AUTHENTICATE = "api/user/authenticate";
export const GET_USER = "api/user";
export const SUBJECTS = "api/subjects";
export const CLASSES = "api/class-rooms";

//majors
export const majors = {
    "CN" : "Công nghệ thông tin",
    "AT" : "An toàn thông tin",
    "DT" : "Điện tử",
    "PT" : "Đa phương tiện",
    "KT" : "Kế toán",
    "VT" : "Viễn thông",
    "MK" : "Marketing",
    "QT" : "Quản trị kinh doanh"
}