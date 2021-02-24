import React from "react";
import { connect } from "react-redux";
import { NavLink } from "react-router-dom";
import Logo from "../assets/images/ptit-icon.png";
import * as actions from '../pages/categories/actions';
import { checkLogin } from '../reducers/app';
import genAvatar from '../components/Avatar';

function Menu(props) {
  
  const onLogout = () => {
    localStorage.removeItem("jwt");
    sessionStorage.removeItem("jwt");
    props.onDeleteAllFromCart();
    props.onCheckLogin(false);
  };

  const onCloseMenu = (e)=>{
    var target = document.getElementById("collapsibleNavId");
    target.classList.remove('show');
  }

  return (
    <nav
      className="navbar navbar-expand-sm navbar-light p-3 text-center"
      style={{
        boxSizing: "border-box",
        fontSize: 14,
        fontWeight: 600,
        backgroundColor: "#eee",
        minHeight: 100
      }}
    >
      <NavLink to="/">
        <img src={Logo} alt="" style={{ width: 50 }} />
      </NavLink>
      <button
        className="navbar-toggler d-lg-none"
        type="button"
        data-toggle="collapse"
        data-target="#collapsibleNavId"
        aria-controls="collapsibleNavId"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="collapsibleNavId">
        <ul className="navbar-nav ml-auto mt-2 mt-lg-0">
          <li className="nav-item ml-2">
            <NavLink className="nav-link" to="/" onClick={onCloseMenu}>
              Home
            </NavLink>
          </li>
          <li className="nav-item ml-2">
            <NavLink className="nav-link" to="/course-regis" onClick={onCloseMenu}>
              Course-regis
            </NavLink>
          </li>
          <li className="nav-item ml-2">
            <NavLink className="nav-link" to="/timetable" onClick={onCloseMenu}>
              Timetable
            </NavLink>
          </li>
          <li className="nav-item ml-2">
            <NavLink className="nav-link" to="/about" onClick={onCloseMenu}>
              About
            </NavLink>
          </li>
          <li className="dropdown ml-2">
            <NavLink
              className="nav-link dropdown-toggle d-flex align-items-center justify-content-center"
              to=""
              id="dropdownId"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              {genAvatar(props.code, 20)}
            </NavLink>
            <div
              className="dropdown-menu"
              aria-labelledby="dropdownId"
              style={{ left: -120 }}
            >
              <p
              style={{ textAlign: "center", padding: "10px", borderBottom: "1px solid rgba(0,0,0,.15)", color: "gray", fontWeight: 300 }}>
                {props.username ? props.username : "User"}
              </p>
              <NavLink className="dropdown-item" to="/edit-info" onClick={onCloseMenu}>
                Information
              </NavLink>
              <NavLink className="dropdown-item" to="/login" onClick={onLogout}>
                Log out
              </NavLink>
            </div>
          </li>
        </ul>
      </div>
    </nav>
  );
}

const mapState = state => {
  return {
    username: state.app.user?.name,
    code: state.app.user?.code
  }
}

const mapDispatch = dispatch => {
  return {
    onDeleteAllFromCart: () => {
      dispatch(actions.deleteAllFromCart())
    },
    onCheckLogin: (status) => {
      dispatch(checkLogin(status))
    }
  }
}

export default connect(mapState, mapDispatch)(Menu);