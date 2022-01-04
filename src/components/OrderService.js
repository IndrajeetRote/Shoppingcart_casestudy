import { intersectionWith } from 'lodash';
import React,{useState,useEffect} from 'react'
import { Button } from 'react-bootstrap'
import { Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';

function OrderService() {
    const [data,setData]=useState([]);
    useEffect(() => {
        getData();
    }, [])
    

    async function getData(){
        let result =await fetch("http://localhost:8095/orders");
        result =await result.json();
        setData(result)
    }
    async function deleteOperation(orderId){
        let result=await fetch("http://localhost:8095/delete/"+orderId,{
            method:'DELETE'
        });
        getData();
     }
     

    return (
        <div>
           <h1>Your Orders</h1>
            <table class="table table-hover table-striped table-dark">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <td>Total Price</td>
                    <th>Debit Number</th>
                    <th>Delivery Address</th>
                    <td>Cancle Order</td>
                </tr>
                </thead>
                <tbody>
                {
                    data.map((item) =>
                    <tr>
                    <td>{item.username}</td>
                    <td>{item.name}</td>
                    <td>{item.price}</td>
                    <td>{item.quantity}</td>
                    <td>{item.totalPrice}</td>
                    <td>{item.debitNo}</td>
                    <td>{item.address}</td>
                    <td><Button style={{backgroundColor:'red',color:'white'}} onClick={() =>{const confirmBox=window.confirm("Do you really want to delete this?"); if (confirmBox === true){deleteOperation(item.orderId)}}}>Cancle Order</Button></td>         
                </tr>        
                    )
                }
                </tbody>
            </table>
            <Button as={Link} to={"/payment"}>Process to Payment</Button>
        
          
        </div>

       
    )
}
export default OrderService;
