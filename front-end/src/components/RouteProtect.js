import React from "react";
import { Redirect, Route } from "react-router-dom";

export default function RouteProtect(props) {
  
  const {path, exact, main} = props;
  let jwt = localStorage.getItem("jwt") || sessionStorage.getItem("jwt");

  return (
    <Route path={path} exact={exact}>
      {jwt ? main : <Redirect to="/login"/> }
    </Route>
  );
}
