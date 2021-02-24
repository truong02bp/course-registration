import ClassDetail from 'pages/ClassDetail/index.js';
import React, { useState } from 'react';
import BottomButton from './BottomButton.js';

function WeeklyTimetable(props) {

    const { subjects, currentWeek, onSetWeek } = props;

    const onChangeWeek = (value) => {
        onSetWeek(value);
    }

    const [classDetail, setClassDetail] = useState();

    const onShowClass = (e)=>{
        var target = e.target;
        var name = target.innerHTML;
        var day = target.getAttribute("data-day");
        var sub = subjects.filter(item => {
            return item.name === name;
        })[0];
        var detail = sub.time.filter(item => {
            return day === item.day;
        });
        setClassDetail({...sub, time: detail});
    }

    const mapToTimetable = () => {
        var xhtml = [];
        if (subjects) {
            for (let i = 1; i < 12; i += 2) {
                var subElement = null;
                var subElementArr = [];
                subjects.forEach((sub) => {
                    subElement = findSubjectElement(sub.time, i);
                    if (subElement.length > 0) {
                        subElement.forEach(detail => {
                            subElementArr.push({
                                name: sub.name,
                                detail: detail
                            })
                        })
                    }
                })
                let tr = (
                    <tr key={Date.now().toString() + i}>
                        <td className="table-dark" width="5%" height={100}>
                            {i} + {i + 1}
                        </td>
                        <td>{mapToTr(subElementArr, "Hai")}</td>
                        <td>{mapToTr(subElementArr, "Ba")}</td>
                        <td>{mapToTr(subElementArr, "Tư")}</td>
                        <td>{mapToTr(subElementArr, "Năm")}</td>
                        <td>{mapToTr(subElementArr, "Sáu")}</td>
                        <td>{mapToTr(subElementArr, "Bảy")}</td>
                        <td>{mapToTr(subElementArr, "CN")}</td>
                    </tr>
                );
                xhtml.push(tr);
            }
        }
        return xhtml;
    }

    const findSubjectElement = (list, value) => {
        var listDetails = [];
        list.forEach(item => {
            if (item.start === value) {
                listDetails.push(item);
            }
        })
        return listDetails;
    }

    const mapToTr = (subElementArr, value) => {
        var xhtml = [];
        subElementArr.forEach(sub => {
            if (sub.detail.week.includes(parseInt(currentWeek))) {
                if (sub.detail.day.toLowerCase() === value.toLowerCase()) {
                    xhtml.push(
                    <h6
                    onClick={onShowClass}
                    data-toggle="modal"
                    data-target="#classDetail"
                    data-day={value}
                    style={{cursor: 'pointer'}}>
                        {sub.name}
                    </h6>
                    )
                    xhtml.push(<span>{sub.detail.room}</span>)
                }
            }
        })
        return xhtml;
    }

    return (
        <>
            <div className="table-responsive text-center" style={
                { minHeight: "calc(100vh - 170px)" }
            }>
                <table className="table table-striped timetable-show table-bordered">
                    <thead className="thead-dark">
                        <tr>
                            <th className="table-dark">Lession</th>
                            <th>Mon</th>
                            <th>Tue</th>
                            <th>Wed</th>
                            <th>Thu</th>
                            <th>Fri</th>
                            <th>Sat</th>
                            <th>Sun</th>
                        </tr>
                    </thead>
                    <tbody>
                        {mapToTimetable()}
                    </tbody>
                </table>
            </div>
            <ClassDetail classDetail={classDetail} />
            <BottomButton
                currentWeek={currentWeek}
                onChangeWeek={onChangeWeek}>
            </BottomButton>
        </>
    )
}

export default WeeklyTimetable;