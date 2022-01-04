import React from 'react'
import { Link } from 'react-router-dom'
import {useState} from 'react'
import { Button, Table } from 'react-bootstrap'
function SearchProductPage() {

    const [data,setData]=useState([])
async function search(category)
  {
    console.log(category)

    let result =await fetch("http://localhost:8093/api/"+category);
    result=await result.json();
    console.warn(result)
    setData(result)
  }  
    
    return (
        <div>
            <Button style={{backgroundImage:`url("https://image.shutterstock.com/image-illustration/computer-devices-mobile-phone-laptop-260nw-217080976.jpg")`,width:300,height:200}} value="electronics" onClick={(e)=>search(e.target.value)}>Electronics</Button>
            <Button style={{backgroundImage:`url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz_IcSZyq9V9-9nJd_nCr-dDRXAoLP8f-j0Q&usqp=CAU")`,width:300,height:200}} value="clothing" onClick={(e)=>search(e.target.value)}>Clothing</Button>
            <Button style={{backgroundImage:`url("https://image.shutterstock.com/image-photo/pearl-golden-bracelets-ring-on-260nw-596878424.jpg")`,width:300,height:200}} value="jwellery" onClick={(e)=>search(e.target.value)}>Jwellery</Button>
            <Button style={{backgroundImage:`url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs0PU4BbI52MH0lkiTcIWc09Nu0KrP9hOiAg&usqp=CAU")`,width:300,height:200}} value="malesshoes" onClick={(e)=>search(e.target.value)}>Males Shoes</Button>
        
         <div className="products">
            {data.map(function(p,index){
            return(
            <div className="card">
                <div>
                    <img className="product-image"
                    src={p.image}
                    alt={p.name}
                    />
                </div>
                <div>
                    <h3 className="product-name">{p.name}</h3>
                </div>
                <div className="product-price">₹{p.price}</div>
                <div><Button variant="outline-success" as={Link} to={`/view/${p.id}`}>View Details</Button></div>
            </div>
        )})}
        </div>
       
            </div>
    
                   

                    
    )
        }  
  
export default SearchProductPage;
