import { apiTokenInterceptors } from 'common/axiosService';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import * as constants from '../categories/constants';
import './style.css'

export default function StudentList() {

    const [list, setList] = useState([]);

    const param = useParams();

    useEffect(() => {
        apiTokenInterceptors("GET", 
        `${constants.GET_USER}/list?classId=${parseInt(param.id)}`, null)
            .then(res => {
                let data = res.data.map(item => {
                    return {
                        id: item.id,
                        code: item.code,
                        name: item.name,
                        class: item.lop
                    }
                })
                setList(data);
            })
            .catch(err => {
                console.log(err);
            })
    }, [param.id])

    const mapListToTable = list.map((item, index) => {
        return(
            <tr key={item.id}>
                <td>{index + 1}</td>
                <td>{item.code}</td>
                <td>{item.name}</td>
                <td>{item.class}</td>
            </tr>
        )
    })

    return (
        <div className="table-responsive mt-4" style={
            { minHeight: "calc(100vh - 170px)" }
            }>
            <table className="table table-striped table-bordered">
                <thead className="thead-dark">
                    <tr>
                        <th>No.</th>
                        <th>Id</th>
                        <th style={{minWidth: 200}}>Name</th>
                        <th>Class</th>
                    </tr>
                </thead>
                <tbody>
                    {mapListToTable}
                </tbody>
            </table>
        </div>
    )
}
