import {jwtDecode} from 'jwt-decode'; // Importando jwt-decode para decodificar o token JWT
import React,{useState} from "react";  
import { useNavigate, Link} from 'react-router-dom';
import Header from "./Header";
import './TelaLogin.css'; // Assuming you have a CSS file for styling

export default function TelaCadastro(){   
    const title = "Cadastro de usuário"; 
    const textTitle1 = "Preencha os campos abaixo para acessar a plataforma";
    const textTitle2 = "Se você já possui uma conta, clique no link de login abaixo";
    
    const [matricula, setMatricula] = useState('');
    const [username, setUsername] = useState(''); 
    const [telefone, setTelefone] = useState(''); 
    const [password, setPassword] = useState('');
    
    const navegar = useNavigate();  
    const url = 'http://localhost:8080/user';

    function handleCadastro(event) { 
        
            navegar('/app'); 
             
        
    }

    return( 
    <> 
        <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
        <div className="login-container"> 
            <Link to="/"  className="link-cadastro" >Entre aqui</Link>
            <form onSubmit={handleCadastro} className="login-form">
                <label className="label-form" htmlFor="email">Email:</label>
                <input className="input-form" type="email" id="username" name="username" placeholder="digite seu email aqui..." required value={username} onChange={(e) => setUsername(e.target.value)}/>
                
                <label className="label-form" htmlFor="matricula">Matrícula:</label>
                <input className="input-form" type="text" id="matricula" name="matricula" placeholder="digite sua matricula aqui..." required value={matricula} onChange={(e) => setMatricula(e.target.value)}/> 

                <label className="label-form" htmlFor="telefone">Telefone:</label>
                <input className="input-form" type="tel" id="telefone" name="telefone" placeholder="digite seu telefone aqui..." required value={telefone} onChange={(e) => setTelefone(e.target.value)}/>

                <label className="label-form" htmlFor="password">Senha:</label>
                <input  className="input-form" type="password" id="password" name="password" placeholder="digite sua senha aqui..." required value={password} onChange={(e) => setPassword(e.target.value)}/>
                
                <button className="btn-form" type="submit">Cadastrar</button>
            </form>
        </div>
    </>)
}