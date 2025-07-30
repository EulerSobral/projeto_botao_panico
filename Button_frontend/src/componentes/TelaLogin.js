import { jwtDecode } from 'jwt-decode';
import React, { useState } from "react";  
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
    
    const handleLogin = async (event) => {
        event.preventDefault(); 
        const url = 'https://localhost:8080/login';

        try {
            const response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ matricula, senha }),
            });

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.message || 'Erro ao realizar login.');
            }

            const data = await response.json();
            console.log('Resposta do backend:', data);
            if (data.token) {
                const token = data.token;
                localStorage.setItem('jwt_token', token); 
                console.log('Token JWT salvo no localStorage.');

          
                try {
                    const decodedToken = jwtDecode(token);
                
                    const userId = decodedToken.userId || decodedToken.sub || decodedToken.id;

                    if (userId) {
                        localStorage.setItem('userId', userId); 
                        console.log('ID do usuário extraído e salvo:', userId);
                        alert('Login bem-sucedido! Bem-vindo(a) usuário: ' + userId);
                    } else {
                        console.warn('ID do usuário não encontrado no payload do JWT.');
                        alert('Login bem-sucedido, mas o ID do usuário não foi encontrado no token.');
                    }

                    navegar('/app'); 
                } catch (decodeError) {
                    console.error('Erro ao decodificar o token JWT:', decodeError);
                    alert('Erro ao processar o token de autenticação.');
                    localStorage.removeItem('jwt_token');
                    localStorage.removeItem('userId');
                }
            } else {
                console.warn('Nenhum token JWT recebido na resposta.');
                alert('Login falhou: Token de autenticação não fornecido.');
            }

        } catch (error) {
            console.error('Erro durante o processo de login:', error.message);
            alert('Erro no login: ' + error.message);
        }
    }


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