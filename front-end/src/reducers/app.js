var initState = {
  loading: false,
  user: {},
  isLogin:
    localStorage.getItem("jwt") || sessionStorage.getItem("jwt") ? true : false,
  isSavedSubjects: false
};

var appReducer = (state = initState, action) => {
  switch (action.type) {

    case "LOADING":
      return { ...state, loading: action.payload };

    case "GET_USER":
      return {...state, user: action.payload};

    case "CHECK_LOGIN": 
      return {...state, isLogin: action.payload};

    case "SAVE_SUBJECTS":
      return {...state, isSavedSubjects: action.payload}

    default:
      return {...state};
  }
};

export default appReducer;

// app actions
export const changeLoading = (payload) => ({
  type: "LOADING",
  payload,
});

export const getUser = (payload) => ({
  type: "GET_USER",
  payload
})

export const checkLogin = (payload) => ({
  type: "CHECK_LOGIN",
  payload
})

export const saveSubjects = (payload) => ({
  type: "SAVE_SUBJECTS",
  payload
})