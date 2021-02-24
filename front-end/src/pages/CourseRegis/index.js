import React from 'react';
import RegisCartTable from './RegisCartTable';
import RegisNote from './RegisNote';
import RegisTable from './RegisTable';
import './style.css';
import RegisControl from './RegisControl';

function CourseRegis() {

    return (
        <div className="course-regis">

            <RegisControl></RegisControl>

            <RegisTable></RegisTable>
            <RegisCartTable></RegisCartTable>
            <RegisNote></RegisNote>
            
        </div>
    )
}

export default CourseRegis;
