import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import React, { useEffect, useMemo } from "react";
import "./App.css";
import routes from "./routes";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import NotFound from "components/NotFound";
import Layout from "components/Layout";
import Login from "pages/Login";
import Loading from "components/Loading";
import { useDispatch, useSelector } from "react-redux";
import { apiToken } from "common/axiosService";
import * as constants from './pages/categories/constants';
import { getUser } from "reducers/app";
import * as toast from './common/toast';

function App() {

  const app = useSelector((state: any) => state.app);
  const dispatch = useDispatch();

  useEffect(() => {
    let jwt = localStorage.getItem("jwt") || sessionStorage.getItem("jwt");
    if(jwt !== null){
      apiToken("GET", constants.GET_USER, null)
      .then(res => {
        dispatch(getUser(res.data));
      })
      .catch(err => {
        toast.errNotify(err.message)
      })
    }
  }, [app.isLogin, app.isSavedSubjects])

  const list = useMemo(() => routes.map((route) => route.path), []);

  return (
    <Router>
      <Switch>
        <Route exact path={list}>
          <Layout route={routes}></Layout>
        </Route>
        <Route exact path="/login">
          <Login />
        </Route>
        <Route path="*">
          <NotFound></NotFound>
        </Route>
      </Switch>

      <ToastContainer></ToastContainer>
      <Loading active={app.loading} />
    </Router>
  );
}

export default App;
