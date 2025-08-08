import React from "react";  
import Header from "./Header";
import "./TelaDispositivo.css";

export default function TelaDispositivo(){ 
    const title = "Botão Físico de pânico"; 
    const textTitle1 = "Pressione qualquer botão para pedir ajuda";
    const textTitle2 = "Tela de simulação do botão físico de pânico";
    const [pressed, setPressed] = React.useState(false); 
    const [hover, setHover] = React.useState(false); 
    let [clicks, setClicks] = React.useState(0);

    return( 
        <> 
            <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
            <div className="container">
                <button className="btn-danger" 
                onClick={() => setClicks(clicks + 1)} 
                onMouseDown={() => setPressed(true)} 
                onMouseUp={() => setPressed(false)}
                onMouseEnter={() => setHover(true)} 
                onMouseLeave={() => setHover(false)}>Pressionar Botão</button>
                <div className="box-states-btn"> 
                    <div className="box-btn state-pressed">   
                        <p className="title-box">Estado</p> 
                        {pressed ? (
                            <p className="pressed">Botão pressionado</p>) : (
                            <p className="not-pressed"> Botão não pressionado</p>)}
                    </div>
                    <div className="box-btn box-hover"> 
                        <p className="title-box">Cursor no botão</p>  
                        {hover ? (
                            <p className="pressed">SIM</p>) : (
                            <p className="not-pressed"> NÃO</p>)}
                    </div> 
                    <div className="box-btn qtd-clicks"> 
                        <p className="title-box">Quantidade de cliques</p>  
                        <p className="clicks">{clicks}</p> 
                        <a className="reset-clicks" href="#"  
                        onClick={() => setClicks(clicks = 0)}>Resetar cliques</a>
                    </div> 
                </div>
            </div>
        </> 
    );
}