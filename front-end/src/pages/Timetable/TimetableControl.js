import React, { useState } from 'react';
import { START_DAY, totalWeeks } from '../categories/constants';

function TimetableControl(props) {

    const [timetable, setTimetable] = useState('weekly');

    const { currentWeek } = props;

    const mapWeeks = (weeks) => {
        var xhtml = [];
        for (let i = 0; i < weeks; i++) {
            let date1 = new Date(convertDayToMilliseconds(i));
            //date2 = date1 + 6days
            let date2 = new Date(convertDayToMilliseconds(i) + 518400000);
            let option = (
                <option key={i} value={i + 1}>
                    Week {i + 1} [{date1.getDate()}/{date1.getMonth() + 1} -- {date2.getDate()}/{date2.getMonth() + 1}]
                </option>
            )
            xhtml.push(option);
        }
        return xhtml;
    }

    const convertDayToMilliseconds = (i) => {
        // startDay + i(weeks)
        return START_DAY + (i * 604800000);
    }

    const onChangeTimetable = (e) => {
        const value = e.target.value;
        props.onChangeTimetable(value);
        setTimetable(value);
    }

    const onSetWeek = (e) => {
        var value = e.target.value;
        props.onSetWeek(parseInt(value));
    }

    return (
        <div className="d-flex justify-content-around mb-3 mt-3 timetable-control">

            <select onChange={onChangeTimetable}>
                <option value="weekly">Weekly Timetable</option>
                <option value="personal">Personal Timetable</option>
            </select>

            <select
                disabled={timetable === "weekly" ? false : true}
                value={currentWeek}
                onChange={onSetWeek}
            >
                {mapWeeks(totalWeeks)}
            </select>

        </div>
    )
}

export default TimetableControl;