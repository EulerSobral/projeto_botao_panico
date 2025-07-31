import { jwtDecode } from 'jwt-decode';
import React, {useState} from "react";   
import { useNavigate, Link} from 'react-router-dom';
import Header from "./Header";
import './TelaLogin.css'; // Assuming you have a CSS file for styling

export default function TelaLogin(){   
    const title = "Login"; 
    const textTitle1 = "Preencha os campos abaixo para acessar a plataforma";
    const textTitle2 = "Se você não possui uma conta, clique no link de cadastro abaixo";
    
    const [senha, setSenha] = useState("");
    const [matricula, setMatricula] = useState(""); 


    const navegar = useNavigate();  
    
    const handleLogin = () => {

                 
             navegar('/app'); 
             

        
    };
 
    return (
    <> 
        <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
        <div className="login-container"> 
            <Link className="link-cadastro" to="/cadastro">Faça seu cadastro aqui</Link>
            <form onSubmit={handleLogin} className="login-form">
                <label className="label-form" htmlFor="matricula">Matrícula:</label>
                <input className="input-form" type="text" id="matricula" name="matricula" placeholder="digite sua matricula aqui..." required value={matricula} onChange={(e) => setMatricula(e.target.value)}/> 
                
                <label className="label-form" htmlFor="password">Senha:</label>
                <input  className="input-form" type="password" id="password" name="password" placeholder="digite sua senha aqui..." required value={senha} onChange={(e) => setSenha(e.target.value)}/>

                
                <button className="btn-form" type="submit" >Entrar</button>
            </form>
        </div>
    </>)
}