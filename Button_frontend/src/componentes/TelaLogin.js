import React, { use } from "react";  
import axios from 'axios'
import { useNavigate, Link} from 'react-router-dom';
import Header from "./Header";
import './TelaLogin.css'; // Assuming you have a CSS file for styling



export default function TelaLogin(){   
    const title = "Login"; 
    const textTitle1 = "Preencha os campos abaixo para acessar a plataforma";
    const textTitle2 = "Se você não possui uma conta, clique no link de cadastro abaixo";

    const url = 'https://localhost:8080/login'; 
    
    const navegar = useNavigate();  
    function handleLogin(event) {
        event.preventDefault(); 
        fetch(url, { 
            method: 'POST', 
            credentials:'include', 
            body: JSON.stringify({ email, senha }),
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username: event.target.username.value,
                password: event.target.password.value
            })
        })
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.error("Erro:", err));
        navegar('/app')
    } 
    return (
    <> 
        <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
        <div className="login-container"> 
            <Link className="link-cadastro" to="/cadastro">Faça seu cadastro aqui</Link>
            <form onSubmit={handleLogin} className="login-form">
                <label className="label-form" htmlFor="username">Email:</label>
                <input className="input-form" type="text" id="username" name="username" placeholder="digite seu email aqui..." required />
                
                <label className="label-form" htmlFor="password">Senha:</label>
                <input  className="input-form" type="password" id="password" name="password" placeholder="digite sua senha aqui..." required />
                
                <button className="btn-form" type="submit" >Entrar</button>
            </form>
        </div>
    </>)
}