import {jwtDecode} from 'jwt-decode'; // Importando jwt-decode para decodificar o token JWT
import React,{useState, useEffect} from "react";   
import './Buttons.css'; // Assuming you have a CSS file for styling

function Buttons(){ 

    const [userId, setUserId] = useState(null);

    const date = new Date();
    useEffect(() => {
        const getUserId = () => {
            const token = localStorage.getItem('jwt_token'); 

            if (token) {
                try {
                    const decodedToken = jwtDecode(token);
                    const id = decodedToken.userId || decodedToken.sub || decodedToken.id;

                    if (id) {
                        setUserId(id);
                    } else {
                        console.warn("ID do usuário não encontrado no token.");
                    }
                } catch (error) {
                    console.error("Erro ao decodificar o token JWT:", error);
                    localStorage.removeItem('jwt_token');
                }
            } else {
                console.log("Nenhum token JWT encontrado no localStorage.");
            }
        };

        getUserId();
    }, [])
        
        const url = 'http://localhost:8080/Buttons';
    
        const handleClick = (local, type, date, id_user) => {
        console.log(`local: ${local}, Type: ${type}, Date: ${date}, User ID: ${id_user}`);

        fetch(url, {
             method: 'POST',
             headers: {
                 'Content-Type': 'application/json',
             },
             body: JSON.stringify({local, type, date, id_user}) // Use userId from state,
         })
         .then(response => response.json())
         .then(data => console.log(data))  }

    return( 
        <> 
            <div className="card-buttons"> 
                <div className="btn-1" onClick={handleClick('IFPB - CG', 'Alerta', date, userId)}> 
                    <p className="text-btn-1">Alerta</p> 
                    <p className="text-btn-2">Notique outros setores</p> 
                </div> 
                <div className="btn-2"  onClick={handleClick('IFPB - CG', 'Policia', date, userId)}> 
                    <p className="text-btn-1">Policia</p> 
                    <p className="text-btn-2">Notique a polícia</p> 
                </div> 
                <div className="btn-3" onClick={handleClick('IFPB - CG', 'Bombeiros', date, userId)}> 
                    <p className="text-btn-1">Bombeiros</p> 
                    <p className="text-btn-2">Notique os bombeiros</p> 
                </div>
            </div> 
        </>
    )
} 

export default Buttons