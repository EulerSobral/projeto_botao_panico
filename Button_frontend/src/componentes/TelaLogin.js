import React, { use } from "react"; 
import { useNavigate, Link} from 'react-router-dom';
import Header from "./Header";
import './TelaLogin.css'; // Assuming you have a CSS file for styling

export default function TelaLogin(){   
    const title = "Login"; 
    const textTitle1 = "Preencha os campos abaixo para acessar a plataforma";
    const textTitle2 = "Se você não possui uma conta, clique no link de cadastro abaixo";
    
    const navegar = useNavigate();  
    function handleLogin(event) {
        event.preventDefault(); 
        //lógica do login 
        navegar('/app')
    } 
    return (
    <> 
        <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
        <div className="login-container"> 
            <Link className="link-cadastro" to="/cadastro">Faça seu cadastro aqui</Link>
            <form onSubmit={handleLogin} className="login-form">
                <label className="label-form" htmlFor="username">Email:</label>
                <input className="input-form" type="email" id="username" name="username" placeholder="digite seu email aqui..." required />
                
                <label className="label-form" htmlFor="password">Senha:</label>
                <input  className="input-form" type="password" id="password" name="password" placeholder="digite sua senha aqui..." required />
                
                <button className="btn-form" type="submit" >Entrar</button>
            </form>
        </div>
    </>)
}