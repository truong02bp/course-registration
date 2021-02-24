import { apiTokenInterceptors } from "common/axiosService";
import React, { useEffect } from "react";
import { connect } from "react-redux";
import * as actions from '../categories/actions';
import * as constants from '../categories/constants';
import * as toast from '../../common/toast';

function RegisControl(props) {

    useEffect(() => {
        props.onGetSubjects();
    }, [])

    const onChooseSubject = (e) => {
        var value = e.target.value;
        apiTokenInterceptors("GET", `${constants.CLASSES}/${value}`, null)
            .then(res => {
                let data = res.data.map((e, i) => {
                    return ({
                        ...e,
                        details: e.details.map((d, j) => {
                            let weeks = d.weeks.map(w => Number(w.name));
                            weeks.sort((a, b) => a - b)
                            return ({ ...d, weeks: weeks })
                        })
                    })
                })
                props.onShowChosenSubject(data);
            })
            .catch(err => {
                toast.errNotify(err.message);
            })
    }

    const mapSubjects = props.subjects.map((sub, index) => {
        return (
            <option key={index} value={sub.id}>
                {`${sub.code} - ${sub.name} ( ${sub.credit} TC )`}
            </option>
        );
    });

    return (
        <div className="regis-control mb-3 mt-3">
            <select onChange={onChooseSubject} defaultValue="subject">
                <option value="subject" disabled>Subject</option>
                {mapSubjects}
            </select>
        </div>
    );
}

const mapState = state => {
    return {
        subjects: state.subjects,
        chosenSubject: state.chosenSubject
    }
}

const mapDispatch = dispatch => {
    return {
        onGetSubjects: () => {
            dispatch(actions.getSubjectRequest())
        },
        onShowChosenSubject: (data) => {
            dispatch(actions.showChosenSubject(data))
        },
    }
}

export default connect(mapState, mapDispatch)(RegisControl);
