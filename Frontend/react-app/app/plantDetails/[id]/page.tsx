"use client";
import { useState, useEffect } from "react"
import Image from "next/image";
import Navbar from '../../../components/Navbar.tsx';

export default function plantDetails({ params }) {
    console.log(params)
    const [plant, setPlant] = useState({})
    const [loading, setLoading] = useState(false)
    useEffect(() => {
       setLoading(true)
        fetch(`http://localhost:5001/plant/details/${params?.id}`)
            .then(response => response.json())
            .then(data => {
                setLoading(false)
                setPlant(data)
            })
    },[])
  return (
    <main className="flex min-h-screen flex-col items-center p-12 bg-backgroundImage bg-center">
        <Navbar/>
        <div className='mt-8 w-full px-24'>
            <div key={plant?.plantId} className="bg-white p-4 mb-4 rounded-md text-black w-full flex">
                <div className="w-1/3">
                    <img className="h-150" src={plant?.imgUrl}></img>

                </div>
                <div className="w-1/3 px-4 my-auto">
                    <p><strong>Description: </strong>{plant?.description}</p>
                </div>
                <div className="w-1/3 px-4 flex-1 flex-col items-center my-auto">
                    <div className="self-center my-auto">
                        <p className="mb-4"><strong>Name: </strong>{plant?.plantName}</p>
                        <p className="mb-4"><strong>Also known as: </strong>{plant?.scientificName}</p>
                        <p className="mb-4"><strong>Planting cycle: </strong>{plant?.cycle}</p>
                        <p className="mb-4"><strong>Watering frequency: </strong>{plant?.watering}</p>
                        <p className="mb-4"><strong>Sunlight: </strong>{plant?.sunlight}</p>
                        <p className="mb-4"><strong>Flower Color: </strong>{plant?.flowerColor}</p>
                        <p className="mb-4"><strong>Growth Rate: </strong>{plant?.growthRate}</p>
                        <p className="mb-4"><strong>Maintenance: </strong>{plant?.maintenance}</p>
                        <p className="mb-4"><strong>Cycle: </strong>{plant?.cycle}</p>
                    </div>
                </div>
            </div>
        </div>
    </main>
  );
}