import React, { useEffect, useState } from 'react';
import './style.css';
import TimetableControl from './TimetableControl';
import WeeklyTimetable from './WeeklyTimetable';
import PersonalTimetable from './PersonalTimetable';
import { connect } from 'react-redux';
import { CURRENT_DAY, START_DAY } from '../categories/constants';

function Timetable(props) {

	const [timetable, setTimetable] = useState('weekly');

	const [currentWeek, setCurrentWeek] =
		useState(Math.floor((CURRENT_DAY - START_DAY) / 604800000) + 1);
		//currentDay - startDay

	const [subjects, setSubjects] = useState([]);

	useEffect(() => {
		var subjects = props.inCartSubjects?.map(item => {
			return (
				{
					id: item.id,
					code: item.subject.code,
					name: item.subject.name,
					nmh: item.nmh,
					crt: item.subject.credit,
					pg: item.tth,
					time: item.details.map(detail => {
						return (
							{
								day: detail.time.name,
								start: detail.time.lesson,
								less: 2,
								room: detail.room.name,
								pro: detail.professor.name,
								week: detail.weeks.map(week => {
									return Number(week.name);
								}).sort((a, b) => a - b),
							}
						)
					})
				}
			)
		})
		setSubjects(subjects);
	}, [props.cart])

	const onChangeTimetable = (value) => {
		setTimetable(value);
	}

	const onSetWeek = (week) => {
		setCurrentWeek(week)
	}

	return (
		<div>
			<TimetableControl
				onChangeTimetable={onChangeTimetable}
				currentWeek={currentWeek}
				onSetWeek={onSetWeek}
			>
			</TimetableControl>
			{
				timetable === "weekly" &&
				<WeeklyTimetable
				subjects={subjects}
				currentWeek={currentWeek}
				onSetWeek={onSetWeek}>
				</WeeklyTimetable>
			}
			{
				timetable === "personal" &&
				<PersonalTimetable subjects={subjects} ></PersonalTimetable>
			}
		</div>
	)
}

const mapState = state => {
	return {
		cart: state.cart,
		inCartSubjects: state.app.user.classRooms
	}
}

export default connect(mapState, null)(Timetable);