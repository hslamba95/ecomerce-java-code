import React, { useState, useEffect } from 'react';

const OrderList = () => {
    const [orders, setOrders] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/orders');
                const data = await response.json();
                setOrders(data);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching orders:', error);
                setLoading(false);
            }
        };

        fetchOrders();
    }, []);

    return (
        <div>
            <h2>Order List</h2>
            {loading ? (
                <p>Loading...</p>
            ) : (
                <ul>
                    {orders.map(order => (
                        <li key={order.id}>
                            Order ID: {order.id}, Amount: {order.amount}, Status: {order.status}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default OrderList;
