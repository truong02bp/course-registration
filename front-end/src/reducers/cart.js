import * as constants from '../pages/categories/constants';
import * as toast from '../common/toast';

var initState = [];

var cartReducer = (state = initState, action) => {

    switch (action.type) {

        case constants.UPDATE_CART:
            const {sub} = action;
            var id = sub.id;
            var nmh = sub.nmh;
            var tth = sub.tth;
            var code = sub.subject.code;
            var check = false;
            if (state.length > 0) {
                state.forEach((item, index) => {
                    if (item.subject.code === code) {
                        check = true;
                        if (item.nmh === nmh && parseInt(item.tth) === parseInt(tth)) {
                            state.splice(index, 1);
                            //toast
                            toast.errNotify('Subject deleted');
                        }
                        else {
                            state[index] = { ...state[index], id, nmh, tth }
                            //toast
                            // toast.warningNotify('Subject updated');
                        }
                    }
                })
            }
            if (check === false) {
                state.push(sub);
                //toast
                // toast.successNotify('Subject added');
            }
            
            return [...state];

        case constants.DELETE_ALL_FROM_CART:
            // toast.errNotify("All deleted");
            return [];

        default:
            return [...state];
    }
}

export default cartReducer;