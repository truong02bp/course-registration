import { apiTokenInterceptors } from 'common/axiosService';
import React, { useEffect, useState } from 'react';
import { connect } from 'react-redux';
import ChangePassForm from './ChangePassForm';
import * as constants from '../categories/constants';
import * as toast from '../../common/toast';
import './style.css';
import genAvatar from 'components/Avatar';

function EditInfoForm(props) {

    const { user } = props;

    useEffect(() => {
        setPhone(user?.phone);
        setEmail(user?.email);
    }, [user])

    const [phone, setPhone] = useState(user?.phone);
    const [email, setEmail] = useState(user?.email);

    const onEditInfo = (e) => {
        var target = e.target;
        var name = target.name;
        var value = target.value;
        if (name === 'phone') {
            setPhone(value);
        }
        else{
            setEmail(value);
        }
    }

    const onUpdate = () => {
        if (validate(phone, email) === "") {
            apiTokenInterceptors("PUT", constants.GET_USER, {
                ...user, phone: phone, email: email
            })
                .then(function () {
                    toast.successNotify("Updated successfully");
                })
                .catch(err => {
                    toast.errNotify(err.message);
                })
        }
        else {
            toast.errNotify(validate(phone, email))
        }
    }

    const validate = (phone, email) => {
        const phoneRegex = "^[0-9]{10}$";
        const emailRegex = "^[a-zA-Z]+[a-zA-Z0-9]*@(gmail.com|ptit.edu.vn)$";
        if (!phone.match(phoneRegex)) {
            return "Số điện thoại sai định dạng !";
        }
        else if (!email.match(emailRegex)) {
            return "Email sai định dạng"
        }
        return "";
    }

    const onCancel = () => {
        setPhone(user?.phone);
        setEmail(user?.email);
    }

    return (
        <div className="edit-form container d-flex justify-content-center align-items-center">
            <div className="edit-form-header mb-4">
                <div className="d-flex flex-column justify-content-center align-items-center">
                    <p>About you</p>
                    {genAvatar(user.code, 50, {
                        width: 85, height: 85, backgroundColor: "white", display: "flex", justifyContent: "center", alignItems: "center",
                        borderRadius: "50%", border: "2px solid rgba(144, 144, 144)"
                    })}
                </div>
            </div>
            <table>
                <tbody>
                    <tr>
                        <td className="label">Name : </td>
                        <td>{user?.name}</td>
                    </tr>
                    <tr>
                        <td className="label">ID : </td>
                        <td>{user?.code}</td>
                    </tr>
                    <tr>
                        <td className="label">Grade : </td>
                        <td>{user?.lop}</td>
                    </tr>
                    <tr>
                        <td className="label">Cohort : </td>
                        <td>{user?.code && convertCohort(user.code)}</td>
                    </tr>
                    <tr>
                        <td className="label">Major : </td>
                        <td>{user?.code && convertMajor(user.code)}</td>
                    </tr>
                    <tr>
                        <td className="label">Honey : </td>
                        <td>{user?.nameHoney ? user.nameHoney : "Ế"}</td>
                    </tr>
                    <tr>
                        <td className="label">Phone number : </td>
                        <td>
                            <input
                                value={phone ? phone : ''}
                                onChange={onEditInfo}
                                type="number"
                                name="phone" />
                        </td>
                    </tr>
                    <tr>
                        <td className="label">Email : </td>
                        <td>
                            <input
                                value={email ? email : ''}
                                onChange={onEditInfo}
                                name="email" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <div className="button-group mt-4 mb-4">
                <button className="btn btn-info" onClick={onUpdate}>
                    <i className="fa fa-check" aria-hidden="true"></i> Update
                </button>
                <button className="btn btn-dark" onClick={onCancel}>
                    <i className="fa fa-ban" aria-hidden="true"></i> Cancel
                </button>
            </div>
            <ChangePassForm />
        </div>
    )
}

const convertCohort = (s) => {
    var startYear = parseInt(s.substring(1, 3)) + 2000;
    var endYear = startYear + 5;
    return startYear + " -- " + endYear;
}

const convertMajor = (s) => {
    var major = s.substring(5, 7);
    return constants.majors[major];
}

const mapState = state => {
    return {
        user: state.app.user
    }
}

export default connect(mapState, null)(EditInfoForm);