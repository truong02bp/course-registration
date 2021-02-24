import { combineReducers } from "redux";
import subjects from "../reducers/subjects";
import cart from "../reducers/cart";
import app from "../reducers/app";
import chosenSubject from '../reducers/chosenSubject';

const appReducer = combineReducers({
  subjects,
  cart,
  app,
  chosenSubject
});

export default appReducer;
