import { apiInterceptors } from "common/axiosService";
import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import Logo from "../../assets/images/ptit-logo.jpg";
import "./style.css";
import * as constants from "../../pages/categories/constants";
import { errNotify, successNotify } from "common/toast";
import { connect } from "react-redux";
import { checkLogin } from "../../reducers/app";

function Login(props) {
    const history = useHistory();

    const [account, setAccount] = useState({
        username: "",
        password: "",
    });

    const [isSaveUser, setIsSaveUser] = useState(false);
    const onChange = (e) => {
        const target = e.target;
        const name = target.name;
        const value = target.value;
        setAccount({
            ...account,
            [name]: value,
        });
    };

    const onTogglePass = ()=>{
        var inputForm = document.querySelector('.form-group.password');
        var passInput = inputForm.querySelector('input[name="password"]');
        var showPassIcon = document.querySelector('.fa.fa-eye');
        var hidePassIcon = document.querySelector('.fa.fa-eye-slash');
        var showOp = showPassIcon.getAttribute('data-op');
        var hideOp = hidePassIcon.getAttribute('data-op');

        passInput.setAttribute('type', passInput.getAttribute('type') === 'password' ? 'text' : 'password');

        showPassIcon.style.opacity = 1 - parseInt(showOp);
        showPassIcon.setAttribute('data-op', 1 - parseInt(showOp));

        hidePassIcon.style.opacity = 1 - parseInt(hideOp);
        hidePassIcon.setAttribute('data-op', 1 - parseInt(hideOp));
    }

    const onLogin = (e) => {
        e.preventDefault();

        apiInterceptors("POST", constants.AUTHENTICATE, {
            username: account.username,
            password: account.password,
        })
            .then((res) => {
                if (res) {
                    if (res.data) {
                        let jwt = res.data.jwt;
                        isSaveUser
                            ? localStorage.setItem("jwt", jwt)
                            : sessionStorage.setItem("jwt", jwt);
                        props.onCheckLogin(true);
                        history.push("/");
                        successNotify(constants.LOGIN_SUCCESSFUL);
                    }
                }
            })
            .catch(function(){
                errNotify(constants.LOGIN_FAILED)
            });
    };

    const onSaveUser = () => {
        setIsSaveUser(true);
    };

    return (
        <div className="login-page">
            <form className="login-form">
                <div className="logo mb-3">
                    <img src={Logo} alt="" />
                </div>

                <div className="form-group">
                    <input
                        onChange={onChange}
                        placeholder="Username"
                        name="username"
                        type="text"
                    />
                </div>

                <div className="form-group password">
                    <input
                        onChange={onChange}
                        placeholder="Password"
                        name="password"
                        type="password"
                    />
                    <i className="fa fa-eye-slash" onClick={onTogglePass} data-op={0} />
                    <i className="fa fa-eye" onClick={onTogglePass} data-op={1} />
                </div>
                <div className="form-group">
                    <input
                        type="checkbox"
                        className="mr-3"
                        id="remember"
                        onChange={onSaveUser}
                    />
                    <label htmlFor="remember">Remember me</label>
                </div>
                <button
                    type="submit"
                    className="login-button form-control btn btn-danger"
                    onClick={onLogin}
                >
                    Login
        </button>
            </form>
        </div>
    );
}

const mapDispatch = dispatch => {
    return{
        onCheckLogin: (status)=>{
            dispatch(checkLogin(status));
        }
    }
}

export default connect(null, mapDispatch)(Login);
