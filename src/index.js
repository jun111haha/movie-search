import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import MovieListStore from "./store/movieStore";
import TvListStore from "./store/tvStore";
import { Provider } from "mobx-react";

const movieListStore = new MovieListStore();
const tvListStore = new TvListStore();

ReactDOM.render(
  <React.StrictMode>
    <Provider movieListStore={movieListStore} tvListStore={tvListStore}>
      <App />
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
