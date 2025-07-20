import React, { useEffect } from "react";
import Header from "./Header"; 
import Buttons from "./Buttons";  


export default function TelaDesktop() { 
  const title = "Botão de pânico"; 
  const textTitle1 = "Pressione qualquer botão para pedir ajuda";
  const textTitle2 = "Escolha o serviço de emergência apropriado para a sua situação"
  
  useEffect(() => { 
    if(navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          fetch("https://minha-api", { 
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              latitude: position.coords.latitude,
              longitude: position.coords.longitude
            })
          }).then(response => {
            if (!response.ok) {
              throw new Error("Erro ao enviar localização");
            }
            return response.json();
          }).then(data => { 
            console.log("Localização enviada com sucesso:", data);
          }).catch(error => {
            console.error("Erro ao enviar localização:", error);
          });
        },
        (error) => {
          console.error("Erro ao obter localização:", error);
        }
      );
    }
  })

  return (
    <> 
      <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/>
      <Buttons/>
    </>
  );
}