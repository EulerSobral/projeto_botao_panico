import React from "react"; 
import './Buttons.css'; // Assuming you have a CSS file for styling

function Buttons(){       
    const handleClick = (local, id, date, token) => {
        console.log(`Local: ${local}, ID: ${id}, Date: ${date}, Token: ${token}`);

        fetch('https://your-backend-url.com/api/alert', {
             method: 'POST',
             headers: {
                 'Content-Type': 'application/json',
             },
             body: JSON.stringify({ local, id, date, token }),
         })
         .then(response => response.json())
         .then(data => console.log(data))
         .catch(error => console.error('Error:', error));
    };

    return( 
        <> 
            <div className="card-buttons"> 
                <div className="btn-1" onClick={() => handleClick('IFPB - CG', 0, '2025-01-01T00:00:00Z', 'token')}> 
                    <p className="text-btn-1">Alerta</p> 
                    <p className="text-btn-2">Notique outros setores</p> 
                </div> 
                <div className="btn-2" onClick={() => handleClick('IFPB - CG', 0, '2025-01-01T00:00:00Z', 'token')}> 
                    <p className="text-btn-1">Policia</p> 
                    <p className="text-btn-2">Notique a polícia</p> 
                </div> 
                <div className="btn-3" onClick={() => handleClick('IFPB - CG', 0, '2025-01-01T00:00:00Z', 'token')}> 
                    <p className="text-btn-1">Bombeiros</p> 
                    <p className="text-btn-2">Notique os bombeiros</p> 
                </div>
            </div> 
        </>
    )
} 

export default Buttons