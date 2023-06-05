import React from 'react';
import {
  HashRouter, Route, Routes
} from "react-router-dom";
import ReactDOM from 'react-dom/client';
import './index.css';
import Countries from './Countries';

const rootElement = document.querySelector("#root");
render(
 <HashRouter>
    <Navbar />
    <div id="mainContent">
      <Routes>
        <Route path="/" element={<Countries />} />
      </Routes>
      <Footer />
    </div>
    <BttAffix />
  </HashRouter>,
  rootElement
);

