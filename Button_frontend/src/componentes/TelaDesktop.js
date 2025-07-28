import React, { useEffect } from "react";
import Header from "./Header";
import Buttons from "./Buttons";  


export default function TelaDesktop() { 
  const title = "Botão de pânico"; 
  const textTitle1 = "Pressione qualquer botão para pedir ajuda";
  const textTitle2 = "Escolha o serviço de emergência apropriado para a sua situação" 

  function sendLocalization(latidude, longitude) {
    fetch('http://localhost:8080/api/localizacao', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        latitude: lat,
        longitude: lng
      })
    })
        .then(response => {
          if (!response.ok) throw new Error("Erro ao enviar localização");
          return response.json();
        })
        .then(data => {
          console.log("Localização enviada com sucesso:", data);
        })
        .catch(error => {
          console.error("Erro ao enviar localização:", error);
        });
  }
  useEffect(() => {
    navigator.geolocation.getCurrentPosition(function (position) {
      let latitude = position.coords.latitude
      let longitude = position.coords.longitude
      sendLocalization(latitude, longitude)
    })


  return (
    <> 
      <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/>
      <Buttons/>
    </>
  );
}