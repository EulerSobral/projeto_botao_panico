import React, { useEffect } from "react";
import Header from "./Header";
import Buttons from "./Buttons";  


export default function TelaDesktop() { 
  const title = "Botão de pânico"; 
  const textTitle1 = "Pressione qualquer botão para pedir ajuda";
  const textTitle2 = "Escolha o serviço de emergência apropriado para a sua situação" 

  const url = 'https://localhost:8080/Button';

  return (
    <> 
      <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/>
      <Buttons/>
    </>
  );
}