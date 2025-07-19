import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import TelaDesktop from './componentes/TelaDesktop';
import TelaLogin from './componentes/TelaLogin';
import TelaCadastro from './componentes/TelaCadastro';
import TelaDispositivo from './componentes/TelaDispositivo';
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<TelaLogin />} />
        <Route path="/app" element={<TelaDesktop />} />
        <Route path="/cadastro" element={<TelaCadastro />} />
        <Route path="/dispositivo" element={<TelaDispositivo />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;