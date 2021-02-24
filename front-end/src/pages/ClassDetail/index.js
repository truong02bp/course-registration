import React from 'react'
import './style.css'

export default function ClassDetail(props) {
	const { classDetail } = props;
	return (
		<div className="modal fade" id="classDetail" tabIndex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
			<div className="modal-dialog modal-dialog-centered" role="document">
				<div className="modal-content">
					<div className="modal-header">
						<h5 className="modal-title">{classDetail ? classDetail.name : ''}</h5>
						<button type="button" className="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div className="modal-body">
						<table>
							<tbody>
								<tr>
									<td className="label">ID : </td>
									<td>{classDetail ? classDetail.nmh : ''}</td>
								</tr>
								<tr>
									<td className="label">Pratice group : </td>
									<td>{classDetail ? 
									(classDetail.pg !== 0 ? classDetail.pg : 'null') 
									: ''}</td>
								</tr>
								<tr>
									<td className="label">Day : </td>
									<td>{classDetail ? classDetail.time[0].day : ''}</td>
								</tr>
								<tr>
									<td className="label">Start lesson : </td>
									<td>{classDetail ? classDetail.time[0].start : ''}</td>
								</tr>
								<tr>
									<td className="label">Room : </td>
									<td>{classDetail ? classDetail.time[0].room : ''}</td>
								</tr>
								<tr>
									<td className="label">Professor : </td>
									<td>{classDetail ? classDetail.time[0].pro : ''}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	)
}