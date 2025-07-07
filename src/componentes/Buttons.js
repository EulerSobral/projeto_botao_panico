import React from "react"; 

function Buttons(){ 
    return( 
        <> 
            <div className="card-buttons"> 
                <div className="btn-1"> 
                    <p className="text-btn-1">Alerta</p> 
                    <p className="text-btn-2">Notique outros setores</p> 
                </div> 
                <div className="btn-2"> 
                    <p className="text-btn-1">Policia</p> 
                    <p className="text-btn-2">Notique a polícia</p> 
                </div> 
                <div className="btn-3"> 
                    <p className="text-btn-1">Bombeiros</p> 
                    <p className="text-btn-2">Notique os bombeiros</p> 
                </div>
            </div> 
        </>
    )
} 

export default Buttons