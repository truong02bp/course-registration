import React from "react";
import { Route, Switch } from "react-router-dom";
import Footer from "./Footer";
import Menu from "./Menu";
import RouteProtect from "./RouteProtect";

export default function Layout(props) {
  const mapRoutes = props.route.map((route, index) => {
    if (route.private) {
      return (
        <RouteProtect
          key={index}
          path={route.path}
          exact={route.exact}
          main={route.main}
        />
      );
    }

    return (
      <Route key={index} path={route.path} exact={route.exact}>
        {route.main}
      </Route>
    );
  });

  return (
    <>
      <Menu></Menu>
      <Switch>{mapRoutes}</Switch>
      <Footer></Footer>
    </>
  );
}
