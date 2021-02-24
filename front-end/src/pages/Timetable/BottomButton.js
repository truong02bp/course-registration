import React from 'react'
import {totalWeeks} from '../categories/constants'

function BottomButton(props){

    const {currentWeek} = props;

    const onChangeWeek = (value) => {
        props.onChangeWeek(value);
    }

    return(
        <div className="bottom-button">
            <button
            className="btn btn-dark"
            data-toggle="tooltip"
            title="First week"
            onClick={() => onChangeWeek(1)}>
                <i className="fa fa-arrow-left" aria-hidden="true"></i>
            </button>
            <button 
            className="btn btn-dark"
            data-toggle="tooltip"
            title="Previous week"
            onClick={() => onChangeWeek(currentWeek-1)}>
                <i className="fa fa-chevron-left" aria-hidden="true"></i>
            </button>
            <button
            className="btn btn-dark"
            data-toggle="tooltip"
            title="Next week"
            onClick={() => onChangeWeek(currentWeek+1)}>
                <i className="fa fa-chevron-right" aria-hidden="true"></i>
            </button>
            <button
            className="btn btn-dark"
            data-toggle="tooltip"
            title="Final week"
            onClick={() => onChangeWeek(totalWeeks)}>
                <i className="fa fa-arrow-right" aria-hidden="true"></i>
            </button>
        </div>
    )
}

export default BottomButton;