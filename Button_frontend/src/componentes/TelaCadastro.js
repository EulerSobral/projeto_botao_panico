import React from "react";  
import { useNavigate, Link} from 'react-router-dom';
import Header from "./Header";
import './TelaLogin.css'; // Assuming you have a CSS file for styling

export default function TelaCadastro(){   
    const title = "Cadastro de usuário"; 
    const textTitle1 = "Preencha os campos abaixo para acessar a plataforma";
    const textTitle2 = "Se você já possui uma conta, clique no link de login abaixo";
    const navegar = useNavigate();  
        function handleCadastro(event) {
            event.preventDefault(); 
            //lógica do cadastro
            navegar('/app')
        } 

    return( 
    <> 
        <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
        <div className="login-container"> 
            <Link to="/"  className="link-cadastro" >Entre aqui</Link>
            <form onSubmit={handleCadastro} className="login-form">
                <label className="label-form" htmlFor="email">Email:</label>
                <input className="input-form" type="email" id="username" name="username" placeholder="digite seu email aqui..." required />
                
                <label className="label-form" htmlFor="matricula">Matrícula:</label>
                <input className="input-form" type="text" id="matricula" name="matricula" placeholder="digite sua matricula aqui..." required />

                <label className="label-form" htmlFor="password">Senha:</label>
                <input  className="input-form" type="password" id="password" name="password" placeholder="digite sua senha aqui..." required />
                
                <button className="btn-form" type="submit">Cadastrar</button>
            </form>
        </div>
    </>)
}