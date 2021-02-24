import { apiTokenInterceptors } from 'common/axiosService';
import React, { useEffect, useState } from 'react';
import * as constants from '../categories/constants';
import * as toast from '../../common/toast';
import { connect, useDispatch } from 'react-redux';
import * as actions from '../categories/actions';
import {saveSubjects} from '../../reducers/app';

function RegisCartTable(props) {

    const { cart } = props;
    const [isShown, setIsShown] = useState(false);

    const dispatch = useDispatch();

    useEffect(() => (
        props.userCart?.forEach(userCart => {
            if (cart.findIndex(cartItem => {
                return parseInt(cartItem.id) === parseInt(userCart.id)
            }) === -1) {
                userCart.isAdded = true;
                let data = {
                    ...userCart,
                    details: userCart.details.map(d => {
                        let weeks = d.weeks.map(w => Number(w.name))
                        weeks.sort((a, b) => a - b)
                        return ({ ...d, weeks })
                    })
                }
                props.onUpdateCart({ ...data });
            }
        })
    ), [props.userCart]);

    const onUpdateCart = (sub) => {
        props.onUpdateCart(sub);
    }

    const onDeleteAllFromCart = () => {
        props.onDeleteAllFromCart();
    }

    const onToggleCart = () => {
        setIsShown(!isShown);
    }

    const totalCredits = () => {
        var total = 0;
        cart.forEach(item => {
            total += parseInt(item.subject.credit);
        })
        return total;
    }

    const totalFee = () => {
        var total = 0;
        cart.forEach(item => {
            total += parseInt(item.subject.credit) * 480000;
        })
        return total;
    }

    const mapToCart = cart.map((item, index) => {
        return (
            <tr key={index}>
                <td>{index + 1}</td>
                <td>{item.subject.code}</td>
                <td>{item.subject.name}</td>
                <td>{item.nmh}</td>
                <td>{item.tth === 0 ? "null" : item.tth}</td>
                <td>{item.subject.credit}</td>
                <td>{480000 * item.subject.credit}</td>
                <td>
                    {item.isAdded ?
                        constants.SAVE_SUCCESSFUL : constants.ADD_TO_CART_SUCCESSFUL}
                </td>
                <td>
                    <button
                        className="btn btn-outline-dark"
                        onClick={() => onUpdateCart(item)}>
                        Delete
                    </button>
                </td>
            </tr>
        )
    })

    const onSaveSubjects = () => {
        if (totalCredits() >= 14 && totalCredits() <= 26) {
            var idList = cart.map(item => {
                var itemObj = { id: parseInt(item.id) }
                return itemObj;
            })
            apiTokenInterceptors("PUT", constants.CLASSES, idList)
                .then(function () {
                    toast.successNotify("Saved to database");
                    dispatch(saveSubjects(true));
                    dispatch(saveSubjects(false));
                })
                .catch(err => {
                    toast.errNotify(err.message);
                });
        }
        else {
            toast.errNotify("14 <= credits <= 26");
        }
    }

    return (
        <div style={{ margin: "30px 20px 0" }}>
            <div className="bg-dark text-white p-3 d-flex justify-content-between align-items-center border-bottom border-bottom-1 border-light">
                <span>{cart.length} subjects</span>
                <button
                    className="btn btn-light p-2"
                    onClick={onToggleCart}
                >
                    {isShown ? "Hide subjects" : "Show subjects"}
                </button>
            </div>

            {isShown &&
                <div className="table-responsive">
                    <table className="table regis-submit-table table-bordered">
                        <thead className="thead-dark">
                            <tr>
                                <th>No.</th>
                                <th>Code</th>
                                <th style={{ minWidth: 200 }}>Name</th>
                                <th>ID</th>
                                <th>PG</th>
                                <th>Crt</th>
                                <th>Fee</th>
                                <th>Status</th>
                                <th>Act</th>
                            </tr>
                        </thead>
                        <tbody>
                            {mapToCart}
                        </tbody>
                    </table>
                </div>}

            <div className="bg-dark text-white d-flex flex-wrap p-3 container-fluid">
                <div className="d-flex justify-content-around col-md-4 col-12 align-items-center p-0">
                    <p className="mr-auto">Credits: {totalCredits()}</p>
                    <p className="mr-md-auto">Fee: {totalFee()}</p>
                </div>
                <div className="col-md-4 offset-md-4 offset-0 col-12 justify-content-around p-0">
                    <button
                        className="btn btn-info"
                        onClick={onSaveSubjects}>
                        <i className="fa fa-check" aria-hidden="true"></i> Save
                    </button>
                    <button
                        className="btn btn-danger float-right"
                        onClick={onDeleteAllFromCart}>
                        Delete All
                    </button>
                </div>
            </div>
        </div>
    )
}

const mapState = state => {
    return {
        cart: state.cart,
        userCart: state.app.user?.classRooms
    }
}

const mapDispatch = dispatch => {
    return {
        onUpdateCart: (sub) => {
            dispatch(actions.updateCart(sub))
        },
        onDeleteAllFromCart: () => {
            dispatch(actions.deleteAllFromCart());
        }
    }
}

export default connect(mapState, mapDispatch)(RegisCartTable);