import { jwtDecode } from 'jwt-decode';
import React, {useState} from "react";   
import { useNavigate, Link} from 'react-router-dom';
import Header from "./Header"; 
import './TelaLogin.css'; // Assuming you have a CSS file for styling
import TelaDesktop from "./TelaDesktop";

export default function TelaCadastro(){   
    const title = "Cadastro de usuário"; 
    const textTitle1 = "Preencha os campos abaixo para acessar a plataforma";
    const textTitle2 = "Se você já possui uma conta, clique no link de login abaixo";
    
    
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [matricula, setMatricula] = useState(""); 
    const [telefone, setTelefone] = useState("");

    const navegar = useNavigate();  
    function handleCadastro(event) {
        event.preventDefault();

        const url = 'https://localhost:8080/user';
        const requestBody = {
            username: email, 
            matricula: matricula,
            telefone: telefone,          
            password: senha    
        };
 

        fetch(url, {
            method: 'POST',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(requestBody), 
        })
        .then(async res => {
            if (res.ok) {
                return res.json();
            }
            const errorData = await res.json();
            throw new Error(errorData.message || 'Erro desconhecido no servidor');
        })
        .then(data => {
            console.log("Dados da resposta do backend:", data);
            if (data.token) {
                localStorage.setItem('jwt_token', data.token);
                console.log("Token JWT salvo no localStorage.");

                try {
                const decodedToken = jwtDecode(data.token);
                const userId = decodedToken.userId || decodedToken.sub || decodedToken.id;

                if (userId) {
                    localStorage.setItem('userId', userId);
                    console.log("ID do usuário decodificado e salvo:", userId);
                    alert("Cadastro realizado com sucesso! ID do usuário: " + userId);
                } else {
                    console.warn("ID do usuário não encontrado no payload do JWT (verifique as chaves: userId, sub, id).");
                    alert("Cadastro realizado, mas ID do usuário não foi encontrado no token.");
                }
            } catch (decodeError) {
                console.error("Erro ao decodificar o token JWT. Token malformado ou inválido:", decodeError);
                alert("Erro ao processar o token de autenticação recebido.");
            }
        } else {
            console.warn("Nenhum token JWT encontrado na resposta do backend.");
            alert("Cadastro realizado, mas nenhum token de autenticação foi retornado. Verifique a resposta do backend.");
        }
        navegar('/app')
    })
    .catch(err => {
        console.error("Erro durante o cadastro:", err.message);
        alert("Falha no cadastro: " + err.message);
    });
}

    return( 
    <> 
        <Header title={title} textTitle1={textTitle1} textTitle2={textTitle2}/> 
        <div className="login-container"> 
            <Link to="/"  className="link-cadastro" >Entre aqui</Link>
            <form onSubmit={handleCadastro} className="login-form">
                <label className="label-form" htmlFor="email">Email:</label>
                <input className="input-form" type="email" id="username" name="username" placeholder="digite seu email aqui..." required value={email} onChange={(e) => setEmail(e.target.value)}/>
                
                <label className="label-form" htmlFor="matricula">Matrícula:</label>
                <input className="input-form" type="text" id="matricula" name="matricula" placeholder="digite sua matricula aqui..." required value={matricula} onChange={(e) => setMatricula(e.target.value)}/> 

                 <label className="label-form" htmlFor="telefone">Telefone:</label>
                <input className="input-form" type="tel" id="telefone" name="telefone" placeholder="digite seu telefone aqui..." required  value={telefone} onChange={(e) => setTelefone(e.target.value)}/>

                <label className="label-form" htmlFor="password">Senha:</label>
                <input  className="input-form" type="password" id="password" name="password" placeholder="digite sua senha aqui..." required value={senha} onChange={(e) => setSenha(e.target.value)}/>
                
                <button className="btn-form" type="submit">Cadastrar</button>
            </form>
        </div>
    </>)
}