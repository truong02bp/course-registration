import { apiInterceptors } from "../../common/axiosService";
import * as constants from "./constants";

//action
const getSubjectsSuccess = (data) => {
	return {
		type: constants.FETCH_SUBJECTS_SUCCESS,
		data,
	};
};

const getSubjectsFailed = (err) => {
	return {
		type: constants.FETCH_SUJBECTS_FAILED,
		err,
	};
};

export const getSubjectRequest = () => {
	return (dispatch) => {
		apiInterceptors("GET", constants.SUBJECTS, null)
			.then((res) => {
				dispatch(getSubjectsSuccess(res));
			})
			.catch((err) => {
				dispatch(getSubjectsFailed(err));
			});
	};
};

export const updateCart = (sub) => {
	//id, code, nmh, name, crt, pg
	return {
		type: constants.UPDATE_CART,
		sub
	}
}

export const showChosenSubject = (data) => {
	return {
		type: constants.SHOW_CHOSEN_SUBJECT,
		data
	}
}

export const deleteAllFromCart = ()=>{
	return {
		type: constants.DELETE_ALL_FROM_CART,
	}
}