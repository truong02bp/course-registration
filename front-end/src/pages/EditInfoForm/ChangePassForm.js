import { apiTokenInterceptors } from 'common/axiosService';
import React from 'react'
import { connect } from 'react-redux';
import * as toast from '../../common/toast'
import * as constants from '../categories/constants'

function ChangePassForm(props){

    const {user} = props;

    const pwdRegex = "^[0-9a-zA-Z]{4,}$";

    const onSavePassChange = ()=>{
        let oldPwd = document.getElementById('old-pwd').value;
        let newPwd = document.getElementById('new-pwd').value;
        let confirmPwd = document.getElementById('confirm-pwd').value;
        if(newPwd !== confirmPwd){
            toast.errNotify(constants.MATCH_PASSWORD_FAILED);
        }
        else if(newPwd === oldPwd){
            toast.errNotify(constants.SAME_PASSWORD)
        }
        else if(!newPwd.match(pwdRegex)){
            toast.errNotify(constants.VALIDATE_PASSWORD)
        }
        else{
            apiTokenInterceptors("PUT", constants.GET_USER, {
                ...user,
                oldPassword: oldPwd,
                password: newPwd
            })
            .then(res => {
                let stt = res.data.httpStatus;
                if(stt === 500){
                    toast.errNotify(constants.WRONG_PASSWORD)
                }
                else{
                    toast.successNotify(constants.UPDATED_SUCCESSFUL)
                }
            })
            .catch(err => {
                toast.errNotify(err.message);
            })
        }
    }

    return (
        <div>
            <p
            data-toggle="modal"
            data-target="#modelId"
            style={{
                color: "#1976d2", 
                fontWeight: 800, 
                cursor: "pointer",
                zIndex: 1
            }}
            >Change password
            </p>
            
            <div className="modal fade" id="modelId" tabIndex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title">Change password</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                        </div>
                        <div className="modal-body">
                            <div className="form-group">
                                <input
                                placeholder="Old password"
                                type="password"
                                id="old-pwd"/>
                            </div>
                            <div className="form-group">
                                <input
                                placeholder="New password"
                                type="password"
                                id="new-pwd"/>
                            </div>
                            <div className="form-group">
                                <input
                                placeholder="Confirm password"
                                type="password"
                                id="confirm-pwd"/>
                            </div>
                        </div>
                        <div className="modal-footer">

                            <button
                            type="button"
                            className="btn btn-dark"
                            data-dismiss="modal">
                                <i className="fa fa-times" aria-hidden="true"></i> Close
                            </button>

                            <button
                            type="button"
                            className="btn btn-info"
                            onClick={onSavePassChange}>
                                <i className="fa fa-check" aria-hidden="true"></i> Save
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

const mapState = state => {
    return{
        user: state.app.user
    }
}

export default connect(mapState, null)(ChangePassForm);