import { createStore, applyMiddleware, compose } from "redux";
import rootReducer from "./rootReducer";
import thunk from "redux-thunk";

const composeDev =
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
    ? compose(
        applyMiddleware(thunk),
        window.__REDUX_DEVTOOLS_EXTENSION__ &&
          window.__REDUX_DEVTOOLS_EXTENSION__()
      )
    : compose(
        applyMiddleware(thunk)
        // window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
      );
const store = createStore(rootReducer, composeDev);

export default store;
