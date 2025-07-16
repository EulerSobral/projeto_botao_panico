import React from "react"; 
import './Header.css'; // Assuming you have a CSS file for styling

function Header(props){ 
    return( 
        <>
        <header> 
            <h1 className="title">{props.title}</h1>
            <p className="text-title-1">{props.textTitle1}</p> 
            <p className="text-title-2">{props.textTitle2}</p> 
        </header> 
        </>
    )
}  

export default Header