import * as constants from '../pages/categories/constants';

var initState = [];

var reducer = (state = initState, action)=>{
    switch(action.type){

        case constants.SHOW_CHOSEN_SUBJECT:
            return action.data;
        default:
            return [...state];
    }
}

export default reducer;