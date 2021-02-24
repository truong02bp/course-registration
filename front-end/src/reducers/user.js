var initState = {};

const userReducer = (state = initState, action) => {
    switch (action.type) {
        case "GET_USER":
            return action.payload;
        default:
            return {};
    }
}

export const getUser = (payload) => ({
    type: "GET_USER",
    payload
})  

export default userReducer;