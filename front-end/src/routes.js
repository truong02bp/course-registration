import React from "react";
import Home from "./pages/Home";
import About from "./pages/About";
import CourseRegis from "./pages/CourseRegis";
import Timetable from "./pages/Timetable";
import EditInfoForm from "./pages/EditInfoForm";
import StudentList from "pages/StudentList";
import Post from "pages/Post";

const routes = [
  {
    path: "/",
    private: false,
    exact: true,
    main: () => <Home />,
  },
  {
    path: "/about",
    private: false,
    exact: false,
    main: () => <About />,
  },
  {
    path: "/course-regis",
    private: true,
    exact: false,
    main: () => <CourseRegis />,
  },
  {
    path: "/timetable",
    private: true,
    exact: true,
    main: () => <Timetable />,
  },
  {
    path: "/edit-info",
    private: true,
    exact: false,
    main: () => <EditInfoForm />,
  },
  {
    path: "/timetable/list/:id",
    private: true,
    exact: true,
    main: () => <StudentList />
  },
  {
    path: "/post",
    private: false,
    exact: true,
    main: ()=> <Post />
  }
];

export default routes;
